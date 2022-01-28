package com.cxytiandi.sharding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.service.UserService;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Object list() {
		return userService.list();
	}
	
	@GetMapping("/add")
	public Object add() {
		for (long i = 0; i < 100; i++) {
			User user = new User();
			user.setCity("深圳");
			user.setName("李四");
			userService.add(user);
		}
//		User user = new User();
//		user.setId(3L);
//		user.setCity("深圳");
//		user.setName("李四");
//		userService.add(user);
		return "success";
	}
	
	@GetMapping("/users/{id}")
	public Object get(@PathVariable Long id) {
		return userService.findById(id);
	}

	// 查询所有涉及的分片将符合的结果返回
	@GetMapping("/users/query")
	public List<User> get(String name) {
		return userService.findByName(name);
	}

	// 范围查询必须要使用标准分片策略，提供RangeShardingAlgorithm实现类
	@GetMapping("/users/between")
	public List<User> get(Long sId, Long eId) {
		return userService.between(sId,eId);
	}
	
}
