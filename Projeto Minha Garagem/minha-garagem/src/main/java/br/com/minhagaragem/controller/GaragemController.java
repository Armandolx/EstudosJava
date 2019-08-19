package br.com.minhagaragem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.minhagaragem.dtos.CarroDto;
import br.com.minhagaragem.entities.Carro;
import br.com.minhagaragem.exception.BadRequestException;
import br.com.minhagaragem.response.ResponseErro;
import br.com.minhagaragem.service.GaragemService;

@RestController //Ja serve para retornar no modelo de JSON
@RequestMapping("/api")
@CrossOrigin(origins = "*") //Para acessar pelo navegador
public class GaragemController {

	@Autowired
	private GaragemService garagemService;
	
	@GetMapping(path = "/carros")
	public ResponseEntity<List<Carro>> listarTodosOsCarros(@RequestParam(value = "ordem", required=false) String campoOrdenacao) throws Exception { //@PathVariable {id} por exemplo	
		List<Carro> carros = garagemService.listarCarros(campoOrdenacao);
		return new ResponseEntity<>(carros , HttpStatus.OK);	
	}
	
	@PostMapping(path = "/carros", produces="application/json")
	public ResponseEntity<Carro> cadastrarCarro(@Valid @RequestBody CarroDto carroDto) throws Exception {
		
		Carro carro = garagemService.salvar(carroDto);
		return new ResponseEntity<>(carro, HttpStatus.OK);	
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	private ResponseEntity<Object> trataExcecao(Exception e) { //Usei o ReponseEntity para alterar o tipo de retorno
		ResponseErro erro = new ResponseErro("400",e.getMessage());
		return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
	}
	
}
