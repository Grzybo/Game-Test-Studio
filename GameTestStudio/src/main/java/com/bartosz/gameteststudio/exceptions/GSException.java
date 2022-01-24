package com.bartosz.gameteststudio.exceptions;

/**
 * Klasa wyjątków.
 * @author Bartosz
 *
 */
public class GSException extends Exception{

	private static final long serialVersionUID = 3633721231170490110L;

	public GSException(Exception e) {
		super(e);
	}
	
	public GSException(String msg, Exception e1) {
		super(msg, e1);
	}
	
	public GSException(String msg) {
		super(msg);
	}
}
