package com.hit.dm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserAuth implements Serializable{

private Long id;
	private String userName;
	private String password;
	
	public UserAuth() {}
	
	public UserAuth(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
