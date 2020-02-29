package com.capg.login.service;
import com.capg.login.dao.*;
import com.capg.login.entities.User;
import com.capg.login.exception.*;

public class LoginService implements ILoginService {
	private UserDaoImple user;
	
	public LoginService(UserDaoImple user) {
		user = user;
	}
	
	public boolean addUser(String username, String password) {
		
		if(username.length()<7 || password.length()<7) {
			throw new ShorterLengthException("username or password length is less then six");
		} else {
			user.addUser(username, new User(username, password));
			return true;
		}
		
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
