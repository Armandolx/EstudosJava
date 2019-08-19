package br.com.cit.primeiroPJSpring.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.cit.primeiroPJSpring.dtos.ViagemDto;
import br.com.cit.primeiroPJSpring.entities.Viagem;
import br.com.cit.primeiroPJSpring.exception.ErroInternoException;
import br.com.cit.primeiroPJSpring.responses.ResponseErro;
import br.com.cit.primeiroPJSpring.responses.ResponseGenerico;
import br.com.cit.primeiroPJSpring.services.ViagemServices;


// entrada do código quando é feita uma chamada, não persiste dados e nem manipula os mesmos.

@RestController // faz o spring entender que essa classe é um controlador
@RequestMapping("/api/viagens") //http://localhost:8089/api/viagens --> irá direto para esse controlador
public class GerenciadorViagemController {

	@Autowired
	private ViagemServices viagemService; // chama Injetar Dependência, para utilizar métodos dessa classe

	@PostMapping // mapeia um método "post"
	public ResponseEntity<ResponseGenerico<Viagem>> cadastrar(@Valid @RequestBody ViagemDto viagemDto, BindingResult result) {
		// o @valid serve para validar conforme colocados no ViagemDto @Length e @NotNull
		// o mesmo atribui os retornos na variavel "result"
		
		// o @resquestBody mapeia o JSON de entrada (do body) para um tipo de ViagemDto
		// se passar "localDeDestino":"Itapema" vai certinho para o ViagemDto (mesmo nome)
		
		ResponseGenerico<Viagem> response = new ResponseGenerico<Viagem>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Viagem viagemSalva = this.viagemService.salvar(viagemDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viagemDto.getId())
				.toUri();
		response.setData(viagemSalva);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping
	public ResponseEntity<List<Viagem>> listar() { //Um método é encapsulado no response e outro não, isso altera como é emitido o retorno
		List<Viagem> viagens = viagemService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(viagens);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseGenerico<Viagem>> buscar(@PathVariable("id") Long id) throws Exception {
  
		Viagem viagem = viagemService.buscar(id);
		ResponseGenerico<Viagem> response = new ResponseGenerico<Viagem>();
		response.setData(viagem);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseGenerico<Viagem>> remover(@PathVariable("id") Long id) throws Exception {
  
		Viagem viagem = viagemService.remover(id);
		ResponseGenerico<Viagem> response = new ResponseGenerico<Viagem>();
		response.setData(viagem);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}

}