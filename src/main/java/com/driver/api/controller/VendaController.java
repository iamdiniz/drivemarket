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

import com.driver.api.assembler.VendaDTOAssembler;
import com.driver.api.assembler.VendaInputDiassembler;
import com.driver.api.model.VendaDTO;
import com.driver.api.model.input.VendaInput;
import com.driver.domain.model.Venda;
import com.driver.domain.repository.VendaRepository;
import com.driver.domain.service.VendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendaDTOAssembler vendaDTOAssembler;
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private VendaInputDiassembler vendaInputDiassembler;

	@GetMapping
	public List<VendaDTO> findAll() {
		return vendaDTOAssembler.toCollectionDTO(vendaRepository.findAll());
	}
	
	@GetMapping("/{vendaId}")
	public VendaDTO findById(@PathVariable Long vendaId) {
		Venda venda = vendaService.buscarOuFalhar(vendaId);
		
		return vendaDTOAssembler.toDTO(venda);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VendaDTO create(@RequestBody @Valid VendaInput vendaInput) {
		Venda venda = vendaInputDiassembler.toDomainObject(vendaInput);
		
		return vendaDTOAssembler.toDTO(venda = vendaService.save(venda));
	}
	
	@PutMapping("/{vendaId}")
	public VendaDTO update(@PathVariable Long vendaId,
			@RequestBody @Valid VendaInput vendaInput) {
		Venda vendaAtual = vendaService.buscarOuFalhar(vendaId);
		
		vendaInputDiassembler.copyToDomainObject(vendaInput, vendaAtual);
		
		return vendaDTOAssembler.toDTO(vendaService.save(vendaAtual));
	}
	
	@DeleteMapping("/{vendaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long vendaId) {
		vendaService.delete(vendaId);
	}
	
}
