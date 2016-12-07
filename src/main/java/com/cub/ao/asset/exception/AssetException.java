package com.cub.ao.asset.exception;


public class AssetException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4641644978190697163L;
	public AssetException(){
		super();
	}
	public AssetException(String errorMessage) {
		super(errorMessage);
	}
	
	
}
