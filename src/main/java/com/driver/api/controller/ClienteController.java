package com.driver.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.driver.api.assembler.ClienteDTOAssembler;
import com.driver.api.assembler.ClienteInputDiassembler;
import com.driver.api.model.ClienteDTO;
import com.driver.api.model.input.ClienteInput;
import com.driver.domain.model.Cliente;
import com.driver.domain.repository.ClienteRepository;
import com.driver.domain.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteDTOAssembler clienteDTOAssembler;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteInputDiassembler clienteInputDiassembler;
	
	@GetMapping
	public List<ClienteDTO> findAll() {
		return clienteDTOAssembler.toCollectionDTO(clienteRepository.findAll());
	}
	
	@GetMapping("/{clienteId}")
	public ClienteDTO findById(@PathVariable Long clienteId) {
		Cliente cliente = clienteService.buscarOuFalhar(clienteId);
		
		return clienteDTOAssembler.toDTO(cliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO create(@RequestBody @Valid ClienteInput clienteInput) {
		Cliente cliente = clienteInputDiassembler.toDomainObject(clienteInput);
		
		return clienteDTOAssembler.toDTO(cliente = clienteService.save(cliente));
	}
	
	@PutMapping("/{clienteId}")
	public ClienteDTO update(@PathVariable Long clienteId,
			@RequestBody @Valid ClienteInput clientInput) {
		Cliente clienteAtual = clienteService.buscarOuFalhar(clienteId);
		
		clienteInputDiassembler.copyToDomainObject(clientInput, clienteAtual);
		
		return clienteDTOAssembler.toDTO(clienteService.save(clienteAtual));
	}
	
	@DeleteMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long clienteId) {
		clienteService.delete(clienteId);
	}
	
}
