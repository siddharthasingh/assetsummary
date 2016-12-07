package com.cub.ao.asset.exception;


public class CombinedDepositException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3381406918491222010L;
	public CombinedDepositException(){
		super();
	}
	public CombinedDepositException(String errorMessage) {
		super(errorMessage);
	}
	
	
}
