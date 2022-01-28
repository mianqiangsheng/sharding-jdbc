package com.cxytiandi.sharding.service;

import com.cxytiandi.sharding.po.Person;
import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.repository.PersonRepository;
import com.cxytiandi.sharding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Long addUser(Person person) {
		return personRepository.addUser0(person);
	}

}
