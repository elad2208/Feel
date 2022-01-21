package com.hit.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

import com.hit.dm.Dj;
import com.hit.dm.User;

@SuppressWarnings("unused")
public class DjDaoImpl implements IDao<Long, Dj> {

	public static final String FILE_PATH = "dj.txt";
	
	ObjectInputStream objectInputStream;
	ObjectOutputStream objectOutputStream;
	
	public DjDaoImpl() {
		try {
			boolean emptyData = checkData();
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
			if(emptyData) {
				objectOutputStream.writeObject(new HashMap<Long, User>());
				objectOutputStream.flush();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delete(Dj entity) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Dj find(Long id) throws IllegalArgumentException {
		HashMap<Long, Dj> djs = null;
		try {
			djs = (HashMap<Long, Dj>) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return djs.get(id);
	}

	@Override
	public boolean save(Dj dj) throws IllegalArgumentException {
		try {
			@SuppressWarnings("unchecked")
			HashMap<Long, Dj> djs = (HashMap<Long, Dj>) objectInputStream.readObject();
			djs.put(dj.getId(), dj);
			objectOutputStream.writeObject(djs);
			objectOutputStream.flush();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean checkData() throws IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		return file.exists() || file.length() == 0;
	}


	
	

}
