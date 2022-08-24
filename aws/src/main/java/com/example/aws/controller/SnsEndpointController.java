package com.example.aws.controller;

import java.net.URISyntaxException;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sns/receive")
public class SnsEndpointController {

    @Autowired
    AmazonSNSClient snsClient;

    @Value("${sns.topic.arn}")
    private String snsTopicARN; 

    @Autowired
    NotificationMessagingTemplate notificationMessagingTemplate;

    @Autowired
    public SnsEndpointController(AmazonSNS amazonSns) {
      this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
    }

    @GetMapping("/list-topics")
    private ListTopicsResult listtopics() throws URISyntaxException {
        ListTopicsResult response = snsClient.listTopics();
        return response;
    }

    @GetMapping("/createTopic/{topicName}")
    private String createTopic(@PathVariable String topicName) throws URISyntaxException {
        snsClient.createTopic(topicName);
        return "Topic Created: ";
    }

  @GetMapping("/addSubscription/{email}")
  public String addSubscriptionToSNSTopic(@PathVariable String email) {
    SubscribeRequest subscribeRequest = new SubscribeRequest(snsTopicARN, "email", email);
    snsClient.subscribe(subscribeRequest);
    return "Subscription request is pending. To confirm the subscription please check your email :"
        + email;
  }

  @GetMapping("/sendNotification")
  public String publishMessageToSNSTopic() {
    PublishRequest publishRequest = new PublishRequest(snsTopicARN, buildMessageBody(),"Testing header");
        snsClient.publish(publishRequest);
        
    return "notification send successfully.";
  }

  private String buildMessageBody() {
    return "Dear coders, This is for Testing";
  }

}
