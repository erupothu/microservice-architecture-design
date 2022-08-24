package com.tutorial.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Primary
@Configuration
public class ProxyApi implements SwaggerResourcesProvider {

	@Autowired
	ZuulProperties properties;

//    @Primary
//    @Bean
//    public SwaggerResourcesProvider swaggerResourcesProvider() {
//        return () -> {
//            List resources = new ArrayList();
//            properties.getRoutes().values().stream()
//                    .forEach(route -> resources.add(createResource(route.getServiceId(), route.getId(), "2.0")));
//            if(resources.size()<1) {
//            	resources.add(createResource("account-service", "/api/account/v2/api-docs", "2.0"));
//            	SwaggerResource swaggerResource = new SwaggerResource();
//                swaggerResource.setName("gateway");
//                swaggerResource.setLocation("/v2/api-docs");
//                
//                swaggerResource.setSwaggerVersion("1.2.0");
//                resources.add(swaggerResource);
//            }
//            return resources;
//        };
//    }

	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "v2/api-docs");
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

	@Override
	public List<SwaggerResource> get() {
		// TODO Auto-generated method stub
		List resources = new ArrayList<>();
		resources.add(createResource("gateway-service", "", "2.0"));
		resources.add(createResource("account-service", "/api/account/v2/api-docs", "2.0"));
		resources.add(createResource("customer-service", "/api/customer/v2/api-docs", "2.0"));
		resources.add(createResource("product-service", "/api/product/v2/api-docs", "2.0"));
		resources.add(createResource("transfer-service", "/api/transfer/v2/api-docs", "2.0"));
		return resources;
	}
}
