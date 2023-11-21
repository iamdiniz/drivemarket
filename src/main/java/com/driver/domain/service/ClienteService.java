package com.driver.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.ClienteNaoEncontradoException;
import com.driver.domain.exception.EntidadeEmUsoException;
import com.driver.domain.exception.NegocioException;
import com.driver.domain.model.Cliente;
import com.driver.domain.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	private static final String MSG_CLIENTE_EM_USO
	= "Cliente de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente save(Cliente cliente) {
		verificarExistencia(cliente);
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void delete(Long clienteId) {
		try {
			buscarOuFalhar(clienteId);
			clienteRepository.deleteById(clienteId);
			clienteRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException(clienteId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_CLIENTE_EM_USO, clienteId));
		}
	}
	
	public Cliente buscarOuFalhar(Long clienteId) {
			return clienteRepository.findById(clienteId)
							.orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
	}
	
	public void verificarExistencia(Cliente cliente) {
		Optional<Cliente> clienteCpf = clienteRepository.findByCpf(cliente.getCpf());
		Optional<Cliente> clienteEmail = clienteRepository.findByEmail(cliente.getEmail());
		
		if (clienteCpf.isPresent() == true) {
			throw new NegocioException(
					String.format("Já existe um cliente com a cpf %s",
							clienteCpf.get().getCpf()));
		}
		
		if (clienteEmail.isPresent() == true) {
			throw new NegocioException(
					String.format("Já existe um cliente com o email %s",
							cliente.getEmail()));
		}
	}

}
