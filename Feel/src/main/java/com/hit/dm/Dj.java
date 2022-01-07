package com.hit.dm;
import java.io.Serializeable;
 
public class Dj<T> implements java.io.Serializeable {
private static final long serialVersionUID=1L;
private T content;
private Long id;

public Dj(java.lang.Long id,T content)
{
	this.id=id;
	this.content=content;
}

@override
public boolean equals(Object obj) {
	if(obj==this) return true;
	if (!(obj instanceof Dj)) return false;
	
	Dj<T> tmp=(Dj<T>) obj;
	
	return this.getDataModelID().equals(tmp.getDataModelID());
}
public T getContent() {
	return content;
}

public Long getDataModelID() {
	return id;
}

@Override
public int hashCode() {
	return this.getDataModelID().hashCode();
}
public void setContent(T content) {
	this.content=content;
}
public void setID(Long id) {
	this.id=id;
}
}
