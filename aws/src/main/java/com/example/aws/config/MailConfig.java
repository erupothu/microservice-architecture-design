package com.example.aws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {
    // @Bean
    // public AmazonSimpleEmailService amazonSimpleEmailService() {

    //   return AmazonSimpleEmailServiceClientBuilder.standard()
    //       .withCredentials(new ProfileCredentialsProvider("pratikpoc"))
    //       .withRegion(Regions.US_EAST_1)
    //       .build();
    // }
    
    // @Bean
    // public MailSender mailSender(
    //             AmazonSimpleEmailService amazonSimpleEmailService) {
    //   return new SimpleEmailServiceMailSender(amazonSimpleEmailService);
    // }
}
