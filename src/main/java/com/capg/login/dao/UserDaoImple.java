package com.capg.login.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.login.entities.*;

public class UserDaoImple {
	Map<String, User> map = new HashMap();
	
	public UserDaoImple() {
		System.out.print("d");
	}
	
	public boolean addUser(String username, User user) {
		map.put(username, user);
		return true;
	}
	
	public boolean removeUser(String username) {
	
		return true;
	}

	public boolean updateUserPassword(String username, String previous_password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean forgetPassword(String username) {
		// TODO Auto-generated method stub
		return false;
	}
}
