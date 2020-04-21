package com.test.test.error;

public class NotFoundException  extends RuntimeException {
	
	private static final long serialVersionUID = 720344521383255358L;

	public NotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
