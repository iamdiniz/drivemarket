package com.driver.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.EntidadeEmUsoException;
import com.driver.domain.exception.NegocioException;
import com.driver.domain.exception.VendedorNaoEncontradoException;
import com.driver.domain.model.Vendedor;
import com.driver.domain.repository.VendedorRepository;

import jakarta.transaction.Transactional;

@Service
public class VendedorService {
	
	private static final String MSG_VENDEDOR_EM_USO
	= "Vendedor de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Transactional
	public Vendedor save(Vendedor vendedor) {
		verificarExistencia(vendedor);
		return vendedorRepository.save(vendedor);
	}
	
	@Transactional
	public void delete(Long vendedorId) {
		try {
			buscarOuFalhar(vendedorId);
			vendedorRepository.deleteById(vendedorId);
			vendedorRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new VendedorNaoEncontradoException(vendedorId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_VENDEDOR_EM_USO, vendedorId));
		}
	}
	
	public Vendedor buscarOuFalhar(Long vendedorId) {
			return vendedorRepository.findById(vendedorId)
							.orElseThrow(() -> new VendedorNaoEncontradoException(vendedorId));
	}
	
	public void verificarExistencia(Vendedor vendedor) {
		Optional<Vendedor> vendedorCpf = vendedorRepository.findByCpf(vendedor.getCpf());
		Optional<Vendedor> vendedorEmail = vendedorRepository.findByEmail(vendedor.getEmail());
		
		if (vendedorCpf.isPresent() == true) {
			throw new NegocioException(
					String.format("Já existe um vendedor com cpf %s",
							vendedorCpf.get().getCpf()));
		}
		
		if (vendedorEmail.isPresent() == true) {
			throw new NegocioException(
					String.format("Já existe um vendedor com o email %s",
							vendedor.getEmail()));
		}
	}

}
