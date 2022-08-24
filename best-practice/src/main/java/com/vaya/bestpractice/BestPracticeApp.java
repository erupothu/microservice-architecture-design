package com.vaya.bestpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableJpaAuditing
@EnableRetry
@OpenAPIDefinition(info = @Info(title = "User API", version = "2.0", description = "User Information"))
// If we excluded the Jackson JSON library and some of the metrics configuration that we don't use, we could save some time on startup:
@EnableAutoConfiguration(exclude = {JacksonAutoConfiguration.class, JvmMetricsAutoConfiguration.class, 
		  LogbackMetricsAutoConfiguration.class, MetricsAutoConfiguration.class})
public class BestPracticeApp implements ApplicationRunner{
	
	private static final Logger log = LoggerFactory.getLogger(BestPracticeApp.class);

	public static void main(String[] args) {
		SpringApplication.run(BestPracticeApp.class, args);
	}

	public void run(ApplicationArguments args) throws Exception {
		log.info("This is info message");
		log.warn("This is warn meassage");
		log.error("This is error message:");
		// TODO Auto-generated method stub
		System.out.println("Best Practice Runner is Active");
		
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}
//	
//	@Bean
//	public SessionLocaleResolver localResolver() {
//		SessionLocaleResolver localResolver = new SessionLocaleResolver();
//		localResolver.setDefaultLocale(Locale.US);
//		return localResolver;
//	}
	
	
}
