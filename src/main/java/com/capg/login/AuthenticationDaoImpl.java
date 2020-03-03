package com.capg.login;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.capg.login.entity.User;
import com.capg.utility.Validate;

public abstract class AuthenticationDaoImpl<ID, P>
        implements IAuthenticationDao<ID, P>, ICredentialStore<ID, P> {
	
    private Set<ID> loginStore = new HashSet<>();

    @Override
    public String login(ID idArg, P passwordArg) {
    	Validate v = new Validate();
    	P password;
    	String c;
    	String type = null;
    	
        Map<ID, P> store = this.store();
        if(store.get(idArg) instanceof  String)
         {
        	System.out.print("instance of string");
        	password = store.get(idArg);
            c = v.cypher((String) passwordArg);
         }else {
        	 System.out.println("instance of user");
        	 User u = (User)store.get(idArg);
        	 password = (P) u.getPassword();
        	 type = u.getType();
        	 c = v.cypher((String) passwordArg);
         }
        
        if (c.equals(password)) {
        	loginStore.add(idArg);
        	if(type == "admin")
            return "login as admin";
        	else
        	return "login as user";
        }
       
        return "login";
    }

    @Override
    public void logout(ID id) {
        loginStore.remove(id);
    }
    
    @Override
    public String getLoginUser () {     
        Iterator iter = loginStore.iterator();        
        return loginStore.isEmpty()?"No login User": (String)iter.next() ;
    }

}
