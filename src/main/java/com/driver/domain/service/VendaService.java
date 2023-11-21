package com.driver.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.driver.domain.exception.EntidadeNaoEncontradaException;
import com.driver.domain.exception.VendaNaoEncontradaException;
import com.driver.domain.model.Carro;
import com.driver.domain.model.Cliente;
import com.driver.domain.model.Venda;
import com.driver.domain.model.Vendedor;
import com.driver.domain.repository.VendaRepository;

import jakarta.transaction.Transactional;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private CarroService carroService;
	
	@Transactional
	public Venda save(Venda venda) {
		Long clienteId = venda.getCliente().getId();
		Cliente cliente = clienteService.buscarOuFalhar(clienteId);
		
		Long vendedorId = venda.getVendedor().getId();
		Vendedor vendedor = vendedorService.buscarOuFalhar(vendedorId);
		
		Long carroId = venda.getCarro().getId();
		Carro carro = carroService.buscarOuFalhar(carroId);
		
		venda.setCliente(cliente);
		venda.setVendedor(vendedor);
		venda.setCarro(carro);
		
		return vendaRepository.save(venda);
	}
	
	@Transactional
	public void delete(Long vendaId) {
		try {
			buscarOuFalhar(vendaId);
			vendaRepository.deleteById(vendaId);
			vendaRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de venda com código %d", vendaId));
		} 
	}
	
	public Venda buscarOuFalhar(Long vendaId) {
			return vendaRepository.findById(vendaId)
							.orElseThrow(() -> new VendaNaoEncontradaException(vendaId));
	}

}
