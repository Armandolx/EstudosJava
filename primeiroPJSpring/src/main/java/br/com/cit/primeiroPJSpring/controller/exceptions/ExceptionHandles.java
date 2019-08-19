package br.com.cit.primeiroPJSpring.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.cit.primeiroPJSpring.exception.ErroInternoException;
import br.com.cit.primeiroPJSpring.responses.ResponseErro;

@ControllerAdvice
public class ExceptionHandles {

	@ExceptionHandler(ErroInternoException.class)
	public ResponseEntity<ResponseErro> handleAllException(Exception ex) {

		ResponseErro response2 = new ResponseErro();
		response2.setErro("Não foi encontrado o id solicitado");
		response2.setStatus(HttpStatus.NO_CONTENT.toString());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
	
	
}
