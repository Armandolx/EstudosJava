package br.com.minhagaragem.exception;

public class BadRequestException extends Exception{

	public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
	
}
