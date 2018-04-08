package com.snkit.springboot.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class SpringcloudzuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringcloudzuulApplication.class).web(true).run(args);
	}
	
	@LoadBalanced
	@Bean 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
