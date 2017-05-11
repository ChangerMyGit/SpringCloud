package com.itmuch.cloud.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.study.domain.User;

@RestController
public class UserController {

	/**
	 * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
	 * 
	 * @RequestMapping(value = "/id", method = RequestMethod.GET)
	 *                       类似的注解还有@PostMapping等等
	 * @param id
	 * @return user信息
	 */
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user = new User();
		user.setId(id);
		user.setUsername("Changer");
		user.setAge(36);
		System.out.println("服务被调用");
		return user;
	}
}
