package com.driver.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.CarroNaoEncontradoException;
import com.driver.domain.model.Carro;
import com.driver.domain.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public Carro buscarOuFalhar(Long carroId) {
			return carroRepository.findById(carroId)
							.orElseThrow(() -> new CarroNaoEncontradoException(carroId));
	}
	
}
