package com.elysian.todoapplication.services;

import java.util.List;

import com.elysian.todoapplication.entity.User;


public interface UserServices {
	
	User verifyUser(String username,String password);
	User registerUser(User user);
	List<User> getAllUsers();

}
