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

import com.driver.api.assembler.FabricanteDTOAssembler;
import com.driver.api.assembler.FabricanteInputDiassembler;
import com.driver.api.model.FabricanteDTO;
import com.driver.api.model.input.FabricanteInput;
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
	
	@Autowired
	private FabricanteInputDiassembler fabricanteInputDiassembler;
	
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
	public FabricanteDTO create(@RequestBody FabricanteInput fabricanteInput) {
		Fabricante fabricante = fabricanteInputDiassembler.toDomainObject(fabricanteInput);
		
		return fabricanteDTOAssembler.toDTO(fabricante = fabricanteService.save(fabricante));
	}
	
	@PutMapping("/{fabricanteId}")
	public FabricanteDTO update(@PathVariable Long fabricanteId,
			@RequestBody FabricanteInput fabricanteInput) {
		Fabricante fabricanteAtual = fabricanteService.buscarOuFalhar(fabricanteId);
		
		fabricanteInputDiassembler.copyToDomainObject(fabricanteInput, fabricanteAtual);
		
		return fabricanteDTOAssembler.toDTO(fabricanteService.save(fabricanteAtual));
	}
	
	@DeleteMapping("/{fabricanteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long fabricanteId) {
		fabricanteService.delete(fabricanteId);
	}

}
