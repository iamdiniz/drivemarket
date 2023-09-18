package com.driver.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.driver.api.assembler.FabricanteDTOAssembler;
import com.driver.api.model.FabricanteDTO;
import com.driver.domain.model.Fabricante;
import com.driver.domain.repository.FabricanteRepository;
import com.driver.domain.service.FabricanteService;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@Autowired
	private FabricanteDTOAssembler fabricanteDTOAssembler;
	
	@GetMapping
	public List<FabricanteDTO> findAll() {
		return fabricanteDTOAssembler.toCollectionDTO(fabricanteRepository.findAll());
	}
	
	@GetMapping("/{fabricanteId}")
	public FabricanteDTO findById(@PathVariable Long fabricanteId) {
		Fabricante fabricante = fabricanteService.buscarOuFalhar(fabricanteId);
		
		return fabricanteDTOAssembler.toDTO(fabricante);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Fabricante create(@RequestBody Fabricante fabricante) {
		return fabricanteService.save(fabricante);
	}
	
	@DeleteMapping("/{fabricanteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long fabricanteId) {
		fabricanteService.delete(fabricanteId);
	}

}
