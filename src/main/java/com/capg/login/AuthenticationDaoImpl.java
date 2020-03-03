package com.capg.login;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.capg.utility.Validate;

public abstract class AuthenticationDaoImpl<ID, P>
        implements IAuthenticationDao<ID, P>, ICredentialStore<ID, P> {
	
    private Set<ID> loginStore = new HashSet<>();

    @Override
    public boolean login(ID idArg, P passwordArg) {
    	Validate v = new Validate();
    	
        Map<ID, P> store = this.store();
        P password = store.get(idArg);
        String c = v.cypher((String) passwordArg);
        
        if (!c.equals(password)) {
            return false;
        }
        loginStore.add(idArg);
        return true;
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
