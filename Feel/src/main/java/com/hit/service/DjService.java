package com.hit.service;
import com.hit.dao.DjDaoImpl;
import com.hit.dao.IDao;
import com.hit.dao.UserDaoImpl;
import com.hit.dm.Dj;
import com.hit.dm.User;
//import lib.SearchAlgoModule;
public class DjService {
	
	DjDaoImpl djDao= new DjDaoImpl();
	UserDaoImpl userDao= new UserDaoImpl();
	//Search
	
	public List<Dj> getAllUserDjs(Long id){
		User user=userDao.find(id);
		return djDao.getAllByName(user.getName());
	}
	

}
