package com.driver.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping
	public List<Fabricante> findAll() {
		return fabricanteRepository.findAll();
	}
	
	@GetMapping("/{fabricanteId}")
	public Fabricante findById(@PathVariable Long fabricanteId) {
		return fabricanteService.buscarOuFalhar(fabricanteId);
	}

}
