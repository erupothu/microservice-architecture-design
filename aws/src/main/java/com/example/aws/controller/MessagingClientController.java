package com.example.aws.controller;

import com.amazonaws.services.sns.AmazonSNS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessagingClientController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessagingClientController.class);
    
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    NotificationMessagingTemplate notificationMessagingTemplate;

    @Autowired
    public MessagingClientController(AmazonSNS amazonSns) {
      this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
    }

    @Value("${cloud.aws.end-point.uri}")
  private String sqsQueueEndPoint;

  @GetMapping("/send/{message}")
  public void sendMessageToSQSQueue(@PathVariable String message) {

    queueMessagingTemplate.send(sqsQueueEndPoint, MessageBuilder.withPayload(message).build());
    // notificationMessagingTemplate.convertAndSend("emailSMSAlert", message);
    notificationMessagingTemplate.send("emailSMSAlert", MessageBuilder.withPayload(message).build());
    LOGGER.info("message send ");
  }

  @SqsListener("testQueue")
  public void fetchMessageFromSQSQueue(String message) {
    LOGGER.info("message from the SQS Queue {}", message);
  }
}
