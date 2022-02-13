package com.hit.controller;

import com.hit.dao.DjDaoImpl;
import com.hit.dao.UserDaoImpl;
import com.hit.dm.Dj;
import com.hit.service.DjService;

public class DjController {
	DjDaoImpl djDao;
	UserDaoImpl userDao;
	DjService djService = new DjService(djDao,userDao );
	
	public void saveDJ(Dj dj) {
		djService.addNewDj(dj);
	}
	
	public void hireDj(Long djId, Long userId) {
		djService.hireDj(djId, userId);
	}
	
	
}
