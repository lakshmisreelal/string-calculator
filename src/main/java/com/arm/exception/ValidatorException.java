package com.arm.exception;

/**
 * Exception created to represent a validation fail in the application.
 *
 * @author Lakshmi Sreelal
 */
public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ValidatorException() {
		super();
	}
	
	public ValidatorException(String msg) {
		this.msg=msg;
	}
	
	@Override
    public String getMessage() {
        return msg;
    }
	
}