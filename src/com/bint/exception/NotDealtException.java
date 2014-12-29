package com.bint.exception;

public class NotDealtException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2016099611924168847L;

	public NotDealtException(){
		super(ExceptionUtil.NOT_DEALED_EXCEPTION);
	}
}
