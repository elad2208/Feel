package com.hit.dm;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Dj implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nickName;
	private Long id;
	private String genre;
	private float price_hour;
	public Dj() {}
	
	public Dj(Long id, String nickName, String genre) {
		this.id = id;
		this.nickName = nickName;
		this.genre = genre;
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}	
	
	
	
	public String getnickName() {
		return nickName;
	}

	public void setnickName(String nickName) {
		this.nickName = nickName;
	}

	public String getgenre() {
		return genre;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}

	public float getpriceperhour() {
		return price_hour;
	}

	public void setpriceperhour(float price) {
		this.price_hour = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dj other = (Dj) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}


	
	
}
