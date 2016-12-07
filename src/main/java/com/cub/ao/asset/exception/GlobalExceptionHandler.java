package com.cub.ao.asset.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController

public class GlobalExceptionHandler {

	
	 
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value= RecordNotFoundException.class)
    public String handleUserNotFoundException(RecordNotFoundException ex){
    	
    			return ex.getMessage();
    }
    
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value= AssetException.class)
    public String handleBaseException(AssetException ex){
    	
		return ex.getMessage();
    }
    

    
}





