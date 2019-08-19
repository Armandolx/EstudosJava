package br.com.cit.primeiroPJSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cit.primeiroPJSpring.dtos.ViagemDto;
import br.com.cit.primeiroPJSpring.entities.Viagem;
import br.com.cit.primeiroPJSpring.exception.ErroInternoException;
import br.com.cit.primeiroPJSpring.repositories.ViagemRepository;

//regras de negócio
@Service
public class ViagemServices {

	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> listar() {
		return viagemRepository.findAll();
	}

	public Viagem salvar(ViagemDto viagemDto) {

		Viagem viagem = new Viagem();

		viagem.setLocalDeDestino(viagemDto.getLocalDeDestino());
		viagem.setDataPartida(viagemDto.getDataPartida());
		viagem.setDataRetorno(viagemDto.getDataRetorno());
		viagem.setAcompanhante(viagemDto.getAcompanhante());
		return viagemRepository.save(viagem);
	}

	public Viagem buscar(Long id) throws Exception {
		Viagem viagem = viagemRepository.findById(id).orElseThrow(() -> new Exception("Não existe esta viagem cadastrada"));
		return viagem;
	}
	
	public Viagem remover(Long id) throws Exception {
		
		Viagem viagem = viagemRepository.findById(id).orElseThrow(() -> new ErroInternoException());
		viagemRepository.deleteById(id);
		return viagem;
	}
}