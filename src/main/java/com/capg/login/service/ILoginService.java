package com.capg.login.service;

import java.util.Map;

import com.capg.login.entity.User;

public interface ILoginService {
	
//	boolean login(String username, String password);
	boolean findByUser(Map<String, Object> store, String str);
	String addUser(Map<String, Object> store, User user); 
	String addUser(Map<String, Object> store, String username, String password);
	boolean removeUser(Map<String, Object> store, String username);
	boolean forgetPassword(Map<String, Object> store, String username, String password);
	
}
