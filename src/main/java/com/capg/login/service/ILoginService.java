package com.capg.login.service;

import java.util.Map;

import com.capg.login.entity.User;

public interface ILoginService {
	
//	boolean login(String username, String password);
	boolean findByUser(String str);
	boolean addUser(Map<String, String> store, User user); 
	boolean addUser(Map<String, String> store, String username, String password);
	boolean removeUser(Map<String, String> store, String username);
	boolean forgetPassword(Map<String, String> store, String username, String password);
	
}
