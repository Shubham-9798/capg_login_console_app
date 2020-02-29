package com.capg.login.service;

public interface ILoginService {
	
	boolean addUser(String username, String password); 
	boolean removeUser(String username);
	boolean updateUserPassword(String username, String previous_password);
	boolean forgetPassword(String username);
	
}
