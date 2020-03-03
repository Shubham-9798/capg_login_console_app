package com.capg.login;


public interface IAuthenticationDao<ID,P> {
	boolean login(ID id,P password);
	void logout(ID id);
	String getLoginUser();
}
