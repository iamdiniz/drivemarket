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

import com.driver.api.assembler.ConcessionariaDTOAssembler;
import com.driver.api.assembler.ConcessionariaInputDiassembler;
import com.driver.api.model.ConcessionariaDTO;
import com.driver.api.model.input.ConcessionariaInput;
import com.driver.domain.model.Concessionaria;
import com.driver.domain.repository.ConcessionariaRepository;
import com.driver.domain.service.ConcessionariaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/concessionarias")
public class ConcessionariaController {
	
	@Autowired
	private ConcessionariaRepository concessionariaRepository;
	
	@Autowired
	private ConcessionariaService concessionariaService;
	
	@Autowired
	private ConcessionariaDTOAssembler concessionariaDTOAssembler;
	
	@Autowired
	private ConcessionariaInputDiassembler concessionariaInputDiassembler;
	
	@GetMapping
	public List<ConcessionariaDTO> findAll() {
		return concessionariaDTOAssembler.toCollectionDTO(concessionariaRepository.findAll());
	}
	
	@GetMapping("/{concessionariaId}")
	public ConcessionariaDTO findById(@PathVariable Long concessionariaId) {
		Concessionaria concessionaria = concessionariaService.buscarOuFalhar(concessionariaId);
		
		return concessionariaDTOAssembler.toDTO(concessionaria);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ConcessionariaDTO create(@RequestBody @Valid ConcessionariaInput concessionariaInput) {
		Concessionaria concessionaria = concessionariaInputDiassembler.toDomainObject(concessionariaInput);
		
		return concessionariaDTOAssembler.toDTO(concessionaria = concessionariaService.save(concessionaria));
	}
	
	@PutMapping("/{concessionariaId}")
	public ConcessionariaDTO update(@PathVariable Long concessionariaId,
			@RequestBody @Valid ConcessionariaInput concessionariaInput) {
		Concessionaria concessionariaAtual = concessionariaService.buscarOuFalhar(concessionariaId);
		
		concessionariaInputDiassembler.copyToDomainObject(concessionariaInput, concessionariaAtual);
		
		return concessionariaDTOAssembler.toDTO(concessionariaService.save(concessionariaAtual));
	}
	
	@DeleteMapping("/{concessionariaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long concessionariaId) {
		concessionariaService.delete(concessionariaId);
	}

}
