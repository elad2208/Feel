package com.hit.server;

import java.io.Serializable;
import java.util.Map;



public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Map<String, String> headers;
	private Map<String, String> body;

	public Request(Map<String, String> headers, Map<String, String> body) {
		super();
		this.headers = headers;
		this.body = body;
	}


	public Map<String, String> getBody() {
		return body;
	}


	public void setBody(Map<String, String> body) {
		this.body = body;
	}


	public Map<String, String> getHeaders() {
		return headers;
	}


	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}


	@Override
	public String toString() {
		return "Request [headers=" + headers + ", body=" + body + "]";
	}
	


}

