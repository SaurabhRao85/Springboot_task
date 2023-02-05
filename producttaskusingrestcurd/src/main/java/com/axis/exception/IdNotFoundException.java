package com.axis.exception;

public class IdNotFoundException extends Throwable {
	String msg;

	public IdNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	
	
	
}
