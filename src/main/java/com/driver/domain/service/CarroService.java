package com.driver.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.CarroNaoEncontradoException;
import com.driver.domain.exception.EntidadeNaoEncontradaException;
import com.driver.domain.exception.NegocioException;
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
	
	@Transactional
	public Carro save(Carro carro) {
			Long fabricanteId = carro.getFabricante().getId();
			
			Fabricante fabricante = fabricanteService.buscarOuFalhar(fabricanteId);
			
			verificarExistencia(carro);
			
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
	
	public void verificarExistencia(Carro carro) {
		Optional<Carro> carroChassi = carroRepository.findByNumeroChassi(carro.getNumeroChassi());
		Optional<Carro> carroPlaca = carroRepository.findByPlaca(carro.getPlaca());
		
		if (carroChassi.isPresent() == true) {
			throw new NegocioException(
					String.format("Já existe um carro com a chassi %s",
							carroChassi.get().getNumeroChassi()));
		}
		
		if (carroPlaca.isPresent() == true) {
			throw new NegocioException(
					String.format("Já existe um carro com a placa %s",
							carro.getPlaca()));
		}
	}
	
}
