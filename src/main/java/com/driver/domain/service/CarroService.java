package com.driver.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.CarroNaoEncontradoException;
import com.driver.domain.exception.EntidadeNaoEncontradaException;
import com.driver.domain.model.Carro;
import com.driver.domain.model.Fabricante;
import com.driver.domain.repository.CarroRepository;

import jakarta.transaction.Transactional;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	public Carro save(Carro carro) {
		Long fabricanteId = carro.getFabricante().getId();
		
		Fabricante fabricante = fabricanteService.buscarOuFalhar(fabricanteId);
		
		carro.setFabricante(fabricante);
		
		return carroRepository.save(carro);
	}
	
	@Transactional
	public void delete(Long carroId) {
		try {
			buscarOuFalhar(carroId);
			carroRepository.deleteById(carroId);
			carroRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de carro com código %d", carroId));
			
		} 
	}
	
	public Carro buscarOuFalhar(Long carroId) {
			return carroRepository.findById(carroId)
							.orElseThrow(() -> new CarroNaoEncontradoException(carroId));
	}
	
}
