package com.ccw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccw.pojos.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByEmailAndPassword(String username, String password);

}
