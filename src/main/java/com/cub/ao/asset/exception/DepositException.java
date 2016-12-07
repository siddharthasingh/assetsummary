package com.cub.ao.asset.exception;


public class DepositException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3381406918491222010L;
	public DepositException(){
		super();
	}
	public DepositException(String errorMessage) {
		super(errorMessage);
	}
	
	
}
