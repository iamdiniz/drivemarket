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

import com.driver.api.assembler.VendedorDTOAssembler;
import com.driver.api.assembler.VendedorInputDiassembler;
import com.driver.api.model.VendedorDTO;
import com.driver.api.model.input.VendedorInput;
import com.driver.domain.model.Vendedor;
import com.driver.domain.repository.VendedorRepository;
import com.driver.domain.service.VendedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VendedorDTOAssembler vendedorDTOAssembler;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private VendedorInputDiassembler vendedorInputDiassembler;
	
	@GetMapping
	public List<VendedorDTO> findAll() {
		return vendedorDTOAssembler.toCollectionDTO(vendedorRepository.findAll());
	}
	
	@GetMapping("/{vendedorId}")
	public VendedorDTO findById(@PathVariable Long vendedorId) {
		Vendedor vendedor = vendedorService.buscarOuFalhar(vendedorId);
		
		return vendedorDTOAssembler.toDTO(vendedor);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VendedorDTO create(@RequestBody @Valid VendedorInput vendedorInput) {
		Vendedor vendedor = vendedorInputDiassembler.toDomainObject(vendedorInput);
		
		return vendedorDTOAssembler.toDTO(vendedor = vendedorService.save(vendedor));
	}
	
	@PutMapping("/{vendedorId}")
	public VendedorDTO update(@PathVariable Long vendedorId,
			@RequestBody @Valid VendedorInput vendedorInput) {
		Vendedor vendedorAtual = vendedorService.buscarOuFalhar(vendedorId);
		
		vendedorInputDiassembler.copyToDomainObject(vendedorInput, vendedorAtual);
		
		return vendedorDTOAssembler.toDTO(vendedorService.save(vendedorAtual));
	}
	
	@DeleteMapping("/{vendedorId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long vendedorId) {
		vendedorService.delete(vendedorId);
	}
	
}
