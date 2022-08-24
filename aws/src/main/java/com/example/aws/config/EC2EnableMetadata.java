package com.example.aws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.context.config.annotation.EnableContextInstanceData;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableContextInstanceData
public class EC2EnableMetadata {
    // @Value("${ami-id: 1234}")
    // private String amiId;

    // @Value("${hostname: example.com}")
    // private String hostname;

    // @Value("${instance-type: t3.nano}")
    // private String instanceType;

    // @Value("${services/domain}")
    // private String serviceDomain;


}
