package com.hit.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.hit.dm.User;

public class UserDaoImpl implements IDao<Long, User>{

	public static final String FILE_PATH = "user.txt";
	
	ObjectInputStream objectInputStream;
	ObjectOutputStream objectOutputStream;
	
	public UserDaoImpl() {
		try {
			boolean emptyData = checkData();
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(FILE_PATH)));
			objectInputStream = new ObjectInputStream(new FileInputStream(new File(FILE_PATH)));
			if(emptyData) {
				objectOutputStream.writeObject(new HashMap<Long, User>());
				objectOutputStream.flush();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(User entity) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public User find(Long id) throws IllegalArgumentException {
		HashMap<Long, User> users = null;
		try {
			users = (HashMap<Long, User>) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return users.get(id);
	}

	@Override
	public boolean save(User user) throws IllegalArgumentException {
		try {
			@SuppressWarnings("unchecked")
			HashMap<Long, User> users = (HashMap<Long, User>) objectInputStream.readObject();
			users.put(user.getId(), user);
			objectOutputStream.writeObject(users);
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
