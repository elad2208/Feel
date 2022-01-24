package com.hit.service;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.hit.dao.DjDaoImpl;
import com.hit.dao.UserDaoImpl;
import com.hit.dm.Dj;
import com.hit.dm.User;

public class DjServiceTest {
	
	@Test
	public void checkDjHiredByUser() {
		
		//Build the layers 		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		DjService DjService = new DjService(new DjDaoImpl(), userDaoImpl);
		
		//Create and save new user		
		User user = new User(4544565l, "Shmoolik", new ArrayList<Long>());
		
		//Create,save and user hire a dj		
		DjService.addNewDj(new Dj(323l, "Ido", "middle eastern"));
		Dj hireDj = DjService.hireDj(323l, 4544565l);
		
		//Assert dj hire action		
		Assert.assertNotNull(hireDj);
		user.addDj(hireDj);
		userDaoImpl.save(user);
		
		//Assert user hired dj		
		Assert.assertTrue(userDaoImpl.find(4544565l).getdjIds().contains(323l));
	}
	

}
