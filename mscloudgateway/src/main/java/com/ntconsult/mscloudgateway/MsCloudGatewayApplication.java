package com.ntconsult.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MsCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCloudGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder
			.routes()
				.route(r -> r.path("/reservations/**").uri("lb://ms-reservation-service"))
				.route(r -> r.path("/notifications/**").uri("lb://ms-notification-service"))
				.route(r -> r.path("/comparissons/**").uri("lb://ms-comparisson-service"))
				.route(r -> r.path("/hotels/**").uri("lb://ms-hotel-service"))
			.build();
	}
}
