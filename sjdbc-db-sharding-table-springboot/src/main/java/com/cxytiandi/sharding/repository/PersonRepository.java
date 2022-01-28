package com.cxytiandi.sharding.repository;

import com.cxytiandi.sharding.po.Person;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface PersonRepository {

	Long addUser0(Person person);

}
