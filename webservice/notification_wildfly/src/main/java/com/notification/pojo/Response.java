package com.notification.pojo;

public class Response {

	String code;
	String message;
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
		
	public Response(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + "]";
	}
	
}
