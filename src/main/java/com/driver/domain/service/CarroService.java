package com.driver.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.CarroNaoEncontradoException;
import com.driver.domain.model.Carro;
import com.driver.domain.model.Fabricante;
import com.driver.domain.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	public Carro salvar(Carro carro) {
		Long fabricanteId = carro.getFabricante().getId();
		
		Fabricante fabricante = fabricanteService.buscarOuFalhar(fabricanteId);
		
		carro.setFabricante(fabricante);
		
		return carroRepository.save(carro);
	}
	
	public Carro buscarOuFalhar(Long carroId) {
			return carroRepository.findById(carroId)
							.orElseThrow(() -> new CarroNaoEncontradoException(carroId));
	}
	
}
