package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieRibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieRibbonApplication.class, args);
	}

	/**
	 * 负载均衡策略
	 * 
	 * @return
	 */
	@Bean
	public IRule ribbonRule() {
		return new RoundRobinRule();
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
