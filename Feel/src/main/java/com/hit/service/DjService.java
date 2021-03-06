package com.hit.service;

import com.hit.dao.DjDaoImpl;
import com.hit.dao.UserDaoImpl;
import com.hit.dm.Dj;
import com.hit.dm.User;

@SuppressWarnings("unused")
public class DjService {
	
	DjDaoImpl djDao;
	UserDaoImpl userDao;
	
	public DjService(DjDaoImpl djDao, UserDaoImpl userDao) {
		this.djDao = djDao;
		this.userDao = userDao;
	}
	
	public void addNewDj(Dj dj) {
		djDao.save(dj);
	}	
	
	public Dj hireDj(Long DjId, Long UserId) {
		Dj dj = djDao.find(DjId);
		if(dj == null)
			return null;
		dj.setHired(true);
		return dj;
	}
}
