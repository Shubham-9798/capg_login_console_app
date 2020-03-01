package com.capg.login.ui;

import static java.lang.System.out;

import java.util.Scanner;

import com.capg.login.dao.*;
import com.capg.login.entities.User;
import com.capg.login.service.*;
import com.capg.login.exception.*;


public class app {
    private ILoginService service = new LoginService(new UserDaoImple());
    private boolean islogin = false;
    private boolean islogout = true;
    private String login_user = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new app().exe(new Scanner(System.in));
		
		
	}
	
	public void exe(Scanner in) {
		// add user, remove user, update user, list user one, all user
		try {
			String user = null;
			String password = null;
			String confirm_password = null;
			
			/*
			 * Add user 
			 * 
			 * forget password
			 * 
			 * remover user
			 * 
			 * login
			 * update user password
			 * logout
			 * 
			 */
			
			// adduser
			if(password.equals(confirm_password))
		     {
				service.addUser(new User(user, password));
		     } else {
		    	 System.out.println("password not same exception");
		     }
		    
		    // check login
		    if(service.login("wui3eiu", "83**8-*_rd*")) {
		    	this.setLogin();
		    	out.println("Succefully login");
		    } 
		    
		    
		    if(service.removeUser("wui3eiu")) {
		    	out.println("user successfully removed");
		    }
		    
		    // updateUserPassword method
		    // enter username, old_password, new_password

		    if(service.findByUser(user))
		    {
		    	String newpassword = "if8jij9";
		    	if(service.updateUserPassword(user, newpassword)) {
		    		out.println("user password update");
		    	} 
            // out.println(service.login("wui3eiu", "83**8-*_rd*"));
		    }
		    
		    // forget password
		    if(service.findByUser("wui3eiu")) {
		    	String newpassword = "if8jij9";
		    	if(service.forgetPassword("wui3eiu", newpassword)) {
		    		out.println("user password update");
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
	}
	
	public void setLogin() {
		 this.islogin = true;
		 this.islogout = false;
	}
	
	public void unsetLogin() {
		this.islogin= false;
		this.islogout = true;
	}	

	public boolean isLogin() {
		return islogin;
	}

	public boolean isLogout() {
		return islogout;
	}
	
//	public void setUserSession() {
//		
//	}
}
