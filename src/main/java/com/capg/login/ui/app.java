package com.capg.login.ui;

import com.capg.login.dao.*;
import com.capg.login.service.*;


public class app {
    private ILoginService service = new LoginService(new UserDaoImple());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new app().exe();
		
	}
	
	public void exe() {
//		service.addUser(username, password);
	}
}
