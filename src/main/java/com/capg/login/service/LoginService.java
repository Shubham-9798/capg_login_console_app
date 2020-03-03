package com.capg.login.service;
import com.capg.login.dao.*;
import com.capg.utility.*;
import com.capg.login.entity.User;
import com.capg.login.exception.*;

import java.util.Map;
import java.util.regex.*;

public class LoginService implements ILoginService {
//	private UserDaoImple user;
	private Validate validate;
	private static final String regex = "^[a-z0-9_-[*]]{6,15}$";
	
	public LoginService() {
		this.validate = new Validate();
	}

	public boolean findByUser(Map<String, Object> store, String str) {
		if(store.containsKey(str)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String addUser(Map<String, Object> store, User user)  {
		String username = user.getUsername();
		String password = user.getPassword();
//		System.out.println(username + " "+ password);
		
		if(username == null || password == null) {
//			return "FFF";
			throw new NullPointerException("either username or password is null");
		}
		else if(username.length() == 0 || password.length() == 0) {
			throw new IllegalArgumentException("either username or password is empty");
		}
		else if(username.length()<6 || password.length()<6) {
			throw new ShorterLengthException("username or password length is less then minimum length six");
		} else {
			if(validate.checkValidation(password)) {

				user.setPassword(validate.cypher(password));
				store.put(username, user);
				return "Successfully Added user";
			} else {
//				System.out.println("min length should be six and max is 15, only include -, _ , *");
				return "min length should be six and max is 15, only include -, _ , *";
			}

		}
	
	}
	
	@Override
	public String addUser(Map<String, Object> store, String username, String password)  {
		
		if(username == null || password == null) {
			throw new NullPointerException("either username or password is null");
		}
		else if(username.length() == 0 || password.length() == 0) {
			throw new IllegalArgumentException("either username or password is empty");
		}
		else if(username.length()<6 || password.length()<6) {
			throw new ShorterLengthException("username or password length is less then minimum length six");
		} else {
			if(validate.checkValidation(password)) {

				store.put(username, validate.cypher(password));
				return "Successfully Added user";
			} else {
//				System.out.println("min length should be six and max is 15, only include -, _ , *");
				return "min length should be six and max is 15, only include -, _ , *";
			}

		}
		
	}
	
	
	public boolean removeUser(Map<String, Object> store, String username) {
	    if(!store.containsKey(username)) {
	    	throw new UserNotFoundException("user not exist");

	    } else {
	    	store.remove(username);
	    	return true;
	    }
//		return user.removeUser(username);
	}


	@Override
	public boolean forgetPassword(Map<String, Object> store, String username, String password) {
		// TODO Auto-generated method stub
		if(validate.checkValidation(password)) {
	    	store.replace(username, validate.cypher(password));
	    	return true;
		} 
		else
		{
			System.out.println("min length should be six and max is 15, only include -, _ , *");
			return false;
			}
		
	}
}
