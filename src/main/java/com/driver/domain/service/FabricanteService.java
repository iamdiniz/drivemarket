package com.driver.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.FabricanteNaoEncontradoException;
import com.driver.domain.model.Fabricante;
import com.driver.domain.repository.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public Fabricante buscarOuFalhar(Long fabricanteId) {
		return fabricanteRepository.findById(fabricanteId)
						.orElseThrow(() -> new FabricanteNaoEncontradoException(fabricanteId));
	}

}
