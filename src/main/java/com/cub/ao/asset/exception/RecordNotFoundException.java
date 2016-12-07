package com.cub.ao.asset.exception;

public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1112784727167097792L;
	public RecordNotFoundException(){
		super();
	}
	public RecordNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	
}
