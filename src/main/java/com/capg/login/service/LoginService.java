package com.capg.login.service;
import com.capg.login.dao.*;
import com.capg.login.entities.User;
import com.capg.login.exception.*;
import java.util.regex.*;

public class LoginService implements ILoginService {
	private UserDaoImple user;
	private static final String regex = "^[a-z0-9_-[*]]{6,15}$";
	
	public LoginService(UserDaoImple user) {
		this.user = user;
	}
	
	public boolean login(String username, String password) {
		return user.login(username, password);
	}
	
	public boolean validate(String text) {
		boolean matches = Pattern.matches(regex, text);
		// System.out.println("regex "+ matches+ " "+ text);
		return matches;
	}
	
	public boolean findByUser(String str) {
		if(user.findByUser(str)) {
			return true;
		}
		return false;
	}
	
	public boolean addUser(User user)  {
		String username = user.getUsername();
		String password = user.getPassword();
		
		if(username == null || password == null) {
			throw new NullPointerException("either username or password is null");
		}
		else if(username.length() == 0 || password.length() == 0) {
			throw new IllegalArgumentException("either username or password is empty");
		}
		else if(username.length()<6 || password.length()<6) {
			throw new ShorterLengthException("username or password length is less then minimum length six");
		} else {
			if(this.validate(password)) {
				this.user.addUser(username, new User(username, password));
				return true;
			} else {
				System.out.println("min length should be six and max is 15, only include -, _ , *");
				return false;
			}

		}
		
	}
	
	public boolean removeUser(String username) {
	    
		return user.removeUser(username);
	}

	public boolean updateUserPassword(String username, String password) {
		// TODO Auto-generated method stub
		
		if(this.validate(password))
		    return user.updateUserPassword(username, password);
		else
			{
			System.out.println("min length should be six and max is 15, only include -, _ , *");
			return false;
			}
			
	}

	public boolean forgetPassword(String username, String password) {
		// TODO Auto-generated method stub
		if(this.validate(password))
		    return user.forgetPassword(username, password);
		else
			{
			System.out.println("min length should be six and max is 15, only include -, _ , *");
			return false;
			}
		
	}
}
