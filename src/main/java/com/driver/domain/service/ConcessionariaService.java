package com.driver.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.EntidadeNaoEncontradaException;
import com.driver.domain.exception.ConcessionariaNaoEncontradaException;
import com.driver.domain.model.Concessionaria;
import com.driver.domain.repository.ConcessionariaRepository;

import jakarta.transaction.Transactional;

@Service
public class ConcessionariaService {
	
	@Autowired
	private ConcessionariaRepository concessionariaRepository;
	
	@Transactional
	public Concessionaria save(Concessionaria concessionaria) {
		return concessionariaRepository.save(concessionaria);
	}
	
	@Transactional
	public void delete(Long concessionariaId) {
		try {
			buscarOuFalhar(concessionariaId);
			concessionariaRepository.deleteById(concessionariaId);
			concessionariaRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de concessionaria com código %d", concessionariaId));
		} 
	}
	
	public Concessionaria buscarOuFalhar(Long concessionariaId) {
			return concessionariaRepository.findById(concessionariaId)
							.orElseThrow(() -> new ConcessionariaNaoEncontradaException(concessionariaId));
	}

}
