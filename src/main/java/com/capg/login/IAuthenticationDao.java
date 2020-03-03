package com.capg.login;


public interface IAuthenticationDao<ID,P> {
	String login(ID id,P password);
	void logout(ID id);
	String getLoginUser();
}
