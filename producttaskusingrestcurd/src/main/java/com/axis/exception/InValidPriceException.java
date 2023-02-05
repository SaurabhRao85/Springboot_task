package com.axis.exception;

public class InValidPriceException extends Throwable {

	String msg;

	public InValidPriceException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	
	

	
}
