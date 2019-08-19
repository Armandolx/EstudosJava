package br.com.minhagaragem.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseErro {

	private String codigo;
	private String mensagem;
}
