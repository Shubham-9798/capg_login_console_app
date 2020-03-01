package com.capg.login.service;

import com.capg.login.entities.User;

public interface ILoginService {
	
	boolean login(String username, String password);
	boolean findByUser(String str);
	boolean addUser(User user); 
	boolean removeUser(String username);
	boolean updateUserPassword(String username, String previous_password);
	boolean forgetPassword(String username, String password);
	
}
