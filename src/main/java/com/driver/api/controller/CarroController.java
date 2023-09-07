package com.driver.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.api.assembler.CarroDTOAssembler;
import com.driver.api.model.CarroDTO;
import com.driver.domain.model.Carro;
import com.driver.domain.repository.CarroRepository;
import com.driver.domain.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private CarroDTOAssembler carroDTOAssembler;
	
	@GetMapping
	public List<CarroDTO> findAll() {
		return carroDTOAssembler.toCollectionDTO(carroRepository.findAll());
	}
	
	@GetMapping("/{carroId}")
	public CarroDTO findById(@PathVariable Long carroId) {
		Carro carro = carroService.buscarOuFalhar(carroId);
		
		return carroDTOAssembler.toDTO(carro);
	}
	
}
