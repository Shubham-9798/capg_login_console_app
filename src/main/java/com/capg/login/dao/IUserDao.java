package com.capg.login.dao;

import com.capg.login.entities.*;

public interface IUserDao {
	
	
	boolean addUser(String username, User password); 
	boolean removeUser(String username);
	boolean updateUserPassword(String username, String previous_password);
	boolean forgetPassword(String username);
	
}
