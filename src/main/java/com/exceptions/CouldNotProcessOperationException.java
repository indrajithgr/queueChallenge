package com.exceptions;

import java.util.NoSuchElementException;

/**
 * @author Indrajith G R Aug 7, 2019 4:30:10 PM
 * @version 1.0.0.0
 */
public class CouldNotProcessOperationException extends Exception {
	private static final long serialVersionUID = -274783433709854325L;
	public CouldNotProcessOperationException(String message) {
		super(message);
	}
	
	public CouldNotProcessOperationException(NoSuchElementException e) {
		super("Could not process operation ",e);
	}
}
