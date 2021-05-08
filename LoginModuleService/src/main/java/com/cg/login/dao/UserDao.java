package com.cg.login.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.login.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {
	
	@Query("Select u From User u WHERE u.username=:username")
	public User getUserByUserName(@Param("username") String username);
	

}
