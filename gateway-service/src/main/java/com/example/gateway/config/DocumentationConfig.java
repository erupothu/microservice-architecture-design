package com.example.gateway.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;

@Primary
@EnableAutoConfiguration
public class DocumentationConfig { // implements SwaggerResourcesProvider

//	public List get() {
//		List resources = new ArrayList<>();
//		resources.add(swaggerResource("account-service", "/api/account/v2/api-docs", "2.0"));
//		resources.add(swaggerResource("customer-service", "/api/customer/v2/api-docs", "2.0"));
//		resources.add(swaggerResource("product-service", "/api/product/v2/api-docs", "2.0"));
//		resources.add(swaggerResource("transfer-service", "/api/transfer/v2/api-docs", "2.0"));
//		return resources;
//	}
//
//	private SwaggerResource swaggerResource(String name, String location, String version) {
//		SwaggerResource swaggerResource = new SwaggerResource();
//		swaggerResource.setName(name);
//		swaggerResource.setLocation(location);
//		swaggerResource.setSwaggerVersion(version);
//		return swaggerResource;
//	}

//	@Bean
//	UiConfiguration uiConfig() {
//		return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
//				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
//	}
}
