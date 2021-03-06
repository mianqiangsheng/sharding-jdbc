package com.cxytiandi.sharding.service;

import java.util.List;

import com.cxytiandi.sharding.po.User;

public interface UserService {

	List<User> list();
	
	Long add(User user);
	
	User findById(Long id);
	
	List<User> findByName(String name);

	List<User> between(Long sId, Long eId);
	
}
