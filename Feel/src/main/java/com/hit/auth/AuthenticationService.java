package com.hit.auth;

import java.util.Map;

import com.hit.dm.UserAuth;

@SuppressWarnings("unused")
public class AuthenticationService {
	

	AuthenticationDao usersAuthDao;
	private Map<String,String> users;
	
	public AuthenticationService(AuthenticationDao usersAuthDao) {
		this.usersAuthDao = usersAuthDao;
	}
	
	public boolean auth(String username, String password) {
		
		UserAuth userAuth = usersAuthDao.findByUsernameAndPassword(username, password);
		
		if(userAuth != null) {	return true;}
	
		
		return false;
	}
	
    public void addUser(String username, String password) {
    	UserAuth userAuth = new UserAuth(username, password);
    	usersAuthDao.save(userAuth);
	}

    public void removeUser(String username) {
    	UserAuth userAuth = new UserAuth(username, "123");
    	usersAuthDao.delete(userAuth);
    }  
	
	public void addNewUserAuth(UserAuth userAuth) {
		usersAuthDao.save(userAuth);
	}	
	
}
