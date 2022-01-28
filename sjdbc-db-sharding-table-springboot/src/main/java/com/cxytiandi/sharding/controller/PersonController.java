package com.cxytiandi.sharding.controller;

import com.cxytiandi.sharding.po.Person;
import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.service.PersonService;
import com.cxytiandi.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/add/user")
	public Object addUser() {
		Person user = new Person();
		user.setId(UUID.randomUUID().getLeastSignificantBits());
		user.setCity("深圳");
		user.setName("李四");
		personService.addUser(user);
		return "success";
	}
	
}
