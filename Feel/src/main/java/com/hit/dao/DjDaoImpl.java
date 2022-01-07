package com.hit.dao;
import java.util.List;
import com.hit.dm.Dj;

public class DjDaoImpl implements IDao<Long, Dj> {

	@Override
	public void delete(Dj entity) {
		
	}
	
	@Override
	public Dj find(Long id) throws IllegalArgumentException{
		return null;
	}
	
	@Override
	public void save(Dj entity) throws IllegalArgumentException{
		
	}

	public List<Dj> getAllByName(String name){
		return null;
	}
}
