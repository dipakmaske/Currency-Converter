package com.ccw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccw.dao.UserDao;
import com.ccw.pojos.User;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao dao;

	public UserService() {
		System.out.println("in ctor" + getClass().getName());
	}

	public User addUser(User u) {

		return dao.save(u);
	}

	public User validateUser(String email, String password) {
		System.out.println("in service");

		return dao.findByEmailAndPassword(email, password);
	}

}
