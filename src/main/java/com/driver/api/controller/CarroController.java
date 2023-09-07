package com.driver.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.api.assembler.CarroDTOAssembler;
import com.driver.api.model.CarroDTO;
import com.driver.domain.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private CarroDTOAssembler carroDTOAssembler;
	
	@GetMapping
	public List<CarroDTO> findAll() {
		return carroDTOAssembler.toCollectionDTO(carroRepository.findAll());
	}
	
}
