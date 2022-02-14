package com.hit.auth;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.hit.dao.IDao;
import com.hit.dm.UserAuth;

public class AuthenticationDao implements IDao<Long, UserAuth>{

	public static final String FILE_PATH = "users.txt";
	
	ObjectInputStream objectInputStream;
	ObjectOutputStream objectOutputStream;
	
	public AuthenticationDao() {
		try {
			boolean emptyData = checkData();
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(FILE_PATH)));
			objectInputStream = new ObjectInputStream(new FileInputStream(new File(FILE_PATH)));
			if(emptyData) {
				objectOutputStream.writeObject(new HashMap<Long, UserAuth>());
				objectOutputStream.flush();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(UserAuth entity) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserAuth find(Long id) throws IllegalArgumentException {
		HashMap<Long, UserAuth> usersAuth = null;
		try {
			usersAuth = (HashMap<Long, UserAuth>) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return usersAuth.get(id);
	}
	
	@SuppressWarnings("unchecked")
	public UserAuth findByUsernameAndPassword(String username, String password) throws IllegalArgumentException {
		HashMap<Long, UserAuth> usersAuth = null;
		UserAuth foundUserAuth  = null;
		
		try {
			usersAuth = (HashMap<Long, UserAuth>) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		  for (UserAuth userAuth : usersAuth.values())
			    if (userAuth.getUserName() == username && userAuth.getPassword() == password)
			    	foundUserAuth =  userAuth;
		  return foundUserAuth;
	
	}

	@Override
	public boolean save(UserAuth userAuth) throws IllegalArgumentException {
		try {
			@SuppressWarnings("unchecked")
			HashMap<Long, UserAuth> usersAuth = (HashMap<Long, UserAuth>) objectInputStream.readObject();
			usersAuth.put(userAuth.getId(), userAuth);
			objectOutputStream.writeObject(usersAuth);
			objectOutputStream.flush();
		} catch (ClassNotFoundException | IOException e) {
			return false;
		}
		return true;
	}

	private boolean checkData() throws IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		return file.exists() || file.length() == 0;
	}
	
}
