package com.hit.dm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class User implements Serializable{

	private Long id;
	private String name;
	private List<Long> djIds = new ArrayList<>();
	
	public User() {}
	
	public User(Long id, String name, List<Long> djIds) {
		super();
		this.id = id;
		this.name = name;
		this.djIds = djIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getdjIds() {
		return djIds;
	}

	public void setdjIds(List<Long> djIds) {
		this.djIds = djIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean addDj(Dj Dj) {
		return djIds.add(Dj.getId());
	}
	
	
	

}
