package com.prumo.portonect.exception;

public class ErroNegocioException extends Exception {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroNegocioException() {
		 super(); 
	 }
	 
	 public ErroNegocioException(String message) {
		 
		 super(message);
		 
	 }

}
