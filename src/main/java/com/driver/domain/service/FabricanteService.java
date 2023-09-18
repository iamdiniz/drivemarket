package com.driver.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.EntidadeEmUsoException;
import com.driver.domain.exception.FabricanteNaoEncontradoException;
import com.driver.domain.model.Fabricante;
import com.driver.domain.repository.FabricanteRepository;

import jakarta.transaction.Transactional;

@Service
public class FabricanteService {
	
	private static final String MSG_FABRICANTE_EM_USO
	= "Fabricante de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Transactional
	public Fabricante save(Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}
	
	@Transactional
	public void delete(Long fabricanteId) {
		try {
			buscarOuFalhar(fabricanteId);
			fabricanteRepository.deleteById(fabricanteId);
			fabricanteRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new FabricanteNaoEncontradoException(fabricanteId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_FABRICANTE_EM_USO, fabricanteId));
		}
	}
	
	public Fabricante buscarOuFalhar(Long fabricanteId) {
		return fabricanteRepository.findById(fabricanteId)
						.orElseThrow(() -> new FabricanteNaoEncontradoException(fabricanteId));
	}

}
