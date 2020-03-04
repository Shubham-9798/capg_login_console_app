package com.capg.login;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capg.login.dao.UserDaoImple;
import com.capg.login.entity.User;
import com.capg.login.exception.*;
import com.capg.login.service.ILoginService;
import com.capg.login.service.LoginService;
import com.capg.utility.Validate;

public class Demo extends AuthenticationDaoImpl {
	
	// provide your own store that contain username, password
	Map<String, Object> store = new HashMap();
	private ILoginService service;

	
	public Demo() {
	 service = new LoginService();
	 // creating object
	 User u1 = new User("shubham", "shubham", "admin");
	 User u2 = new User("shubham1", "shubham1"); 
	 
	 out.println(service.addUser(store, u1));
	 out.println(service.addUser(store, u2));
	 out.println(service.addUser(store, "shubham3", "shubham"));
	 
	}
	
	public static void main(String ...args) {
		new Demo().exe(new Scanner(System.in));
	}	
	
	public void exe(Scanner in) {
		String username = null; 
        String password = null;

		System.out.println("Enter username");
		username = in.next();
		
		System.out.println("Enter password");
		password = in.next();
		
		loginCheck(username, password);
		
		forgetPassword(username, "newpassword");
		
		this.logout(username);
		System.out.println(this.getLoginUser());
		
	}

	@Override
	public Map store() {
		// TODO Auto-generated method stub
		return this.store;
	}
	
	public String loginCheck(String username, String password) {
		try {

			if(username == null || password == null) {
				throw new NullPointerException("either username or password is null");
			}
			else if(username.length() == 0 || password.length() == 0) {
				throw new IllegalArgumentException("either username or password is empty");
			}
			else {
					return this.login(username, password);
			  }
		}
		catch (UserNotFoundException e) {
			// out.println(e);
			return e.getMessage();
		} 
		catch (NullPointerException e) {
			// out.println(e);
			return e.getMessage();
		}
		catch (IllegalArgumentException e) {
			// out.println(e);
			return e.getMessage();
		}
	}
	
	public void forgetPassword(String user, String newpassword) {
		
	    if(service.findByUser(store, user)) {
	    	if(service.forgetPassword(store, user, newpassword)) {
	    		out.println("user password update");
	    	} 
	    } else {
	    	    out.println("user not exist");
	    }
	}

	
}
