package com.prumo.portonect.exception;

@SuppressWarnings("serial")
public class NotConfirmedUserException extends RuntimeException {
	
	 public NotConfirmedUserException() {
		 super(); 
	 }
	 
	 public NotConfirmedUserException(String message) {
		 
		 super(message);
		 
	 }
	
}
