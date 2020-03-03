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
	Map<String, String> store = new HashMap();
	private ILoginService service;

	
	public Demo() {
	 service = new LoginService(new UserDaoImple());
	 User u1 = new User("shreya", "shreya");
	 
	 service.addUser(store, u1);
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
		
		
		try {

			if(username == null || password == null) {
				throw new NullPointerException("either username or password is null");
			}
			else if(username.length() == 0 || password.length() == 0) {
				throw new IllegalArgumentException("either username or password is empty");
			}
			else {
				if(this.login(username, password)) {
					System.out.println("successfully loged in");
				}
				else {
					System.out.println("invalid username and password");
				}
			}
		}
		catch (UserNotFoundException e) {
			out.println(e);
		} 
		catch (ShorterLengthException e) {
			out.println(e);
		}
		catch (NullPointerException e) {
			out.println(e);
		}
		catch (IllegalArgumentException e) {
			out.println(e);
		}
		
		// forgetPassword("shreya");
		System.out.println(this.getLoginUser());
		this.logout(username);
		System.out.println(this.getLoginUser());
		
	}

	@Override
	public Map store() {
		// TODO Auto-generated method stub
		return this.store;
	}
	
	public void forgetPassword(String user) {
		
	    if(service.findByUser(user)) {
	    	String newpassword = "if8jij9";
	    	if(service.forgetPassword(store, user, newpassword)) {
	    		out.println("user password update");
	    	} 
	    }
	}

}
