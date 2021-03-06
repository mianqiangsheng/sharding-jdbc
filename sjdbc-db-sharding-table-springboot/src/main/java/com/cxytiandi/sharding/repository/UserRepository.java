package com.cxytiandi.sharding.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cxytiandi.sharding.po.User;


@Mapper
public interface UserRepository {
	
	Long addUser(User user);
	
	List<User> list();
	
	User findById(Long id);

	List<User> findByName(String name);

	List<User> between(Long sId, Long eId);
}
