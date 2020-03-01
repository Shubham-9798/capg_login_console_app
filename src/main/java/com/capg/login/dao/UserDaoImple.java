package com.capg.login.dao;

import java.util.HashMap;
import com.capg.login.exception.*;
//import java.util.logging.Logger; 
import java.util.Map;

import com.capg.login.entities.*;

public class UserDaoImple {
	Map<String, User> map ;
	
	public UserDaoImple() {
		map = new HashMap();
	}
	
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
	    if(!map.containsKey(username)) {
	    	throw new UserNotFoundException("user not exist");

	    } else {
	    	
	    	User u = map.get(username);
//	    	System.out.println(u + " "+ username);
//	    	System.out.println(u.getPassword() + " "+ password);
	    	
	    	if(u.getUsername() == username && u.getPassword() == password) {
	    		return true;
	    	}
	    	throw new UserNotFoundException("user or password may wrong exist");
	    	
	    }
	}
	
	
	public boolean findByUser(String username) {
	    if(map.containsKey(username)) {
	    	return  true;

	    } else {
	    	throw new UserNotFoundException("user not exist");
	    }
	}
	
	public boolean addUser(String username, User user) {
		map.put(username, user);
		System.out.println(map);
		return true;
	}
	
	public boolean removeUser(String username) {
	    if(!map.containsKey(username)) {
	    	throw new UserNotFoundException("user not exist");

	    } else {
	    	map.remove(username);
	    	return true;
	    }
		
	}

	public boolean updateUserPassword(String username, String password) {
		// TODO Auto-generated method stub
	    	User u = new User(username, password);
	    	map.replace(username, u);
	    	
	    	return true;
	}

	public boolean forgetPassword(String username, String password) {
		// TODO Auto-generated method stub
    	User u = new User(username, password);
    	map.replace(username, u);
    	
    	return true;
	}
}
