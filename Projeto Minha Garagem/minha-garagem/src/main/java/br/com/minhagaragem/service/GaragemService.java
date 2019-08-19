package br.com.minhagaragem.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.minhagaragem.dtos.CarroDto;
import br.com.minhagaragem.entities.Carro;
import br.com.minhagaragem.exception.BadRequestException;
import br.com.minhagaragem.repository.GaragemRepository;


@Service
public class GaragemService {

	@Autowired
	private GaragemRepository garagemRepository;
	
	public List<Carro> listarTodosCarros() {
		return garagemRepository.findAll();
	}
	
	public List<Carro> listarTodosCarrosOrdenados(String campoOrdencao){
		List<Carro> carros = garagemRepository.findAll(Sort.by(Sort.Direction.ASC, campoOrdencao));
		return carros;
	}
	
	public List<Carro> listarCarros(String campoOrdenacao) throws Exception{
		
		if(StringUtils.isEmpty(campoOrdenacao)) 
		{
			return this.listarTodosCarros();
		}
		
		Class<Carro> carrosReflect = Carro.class;
		
		for(Field campo : carrosReflect.getDeclaredFields()) {
			if(campo.getName().equals(campoOrdenacao)) {
				return this.listarTodosCarrosOrdenados(campoOrdenacao);
			}		
		}
		throw new BadRequestException("Campo informado para ordenção se refere a nenhum valor para os campos de carro");
	}
	
	public Carro salvar(CarroDto carroDto) {

		Carro carro = new Carro(
				carroDto.getId(),
				carroDto.getModelo(),
				carroDto.getMarca(),
				carroDto.getPlaca(),
				carroDto.getDataAquisicao(),
				carroDto.getValorPago(),
				carroDto.getValorEstimado(),
				carroDto.getCor()
				);
		
		return garagemRepository.save(carro);
	}

}
