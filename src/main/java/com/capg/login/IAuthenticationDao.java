package com.capg.login;


public interface IAuthenticationDao<ID,P> {
	String login(ID id,P password);
	String logout(ID id);
	String getLoginUser();
}
