package com.itmuch.cloud.study.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;

@RestController
public class MovieConsumerController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/ribbon/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
	}

	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort());
		return "Success";
	}
}
