package com.driver.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.driver.api.assembler.CarroDTOAssembler;
import com.driver.api.assembler.CarroInputDiassembler;
import com.driver.api.model.CarroDTO;
import com.driver.api.model.input.CarroInput;
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
	
	@Autowired
	private CarroInputDiassembler carroInputDiassembler;
	
	@GetMapping
	public List<CarroDTO> findAll() {
		return carroDTOAssembler.toCollectionDTO(carroRepository.findAll());
	}
	
	@GetMapping("/{carroId}")
	public CarroDTO findById(@PathVariable Long carroId) {
		Carro carro = carroService.buscarOuFalhar(carroId);
		
		return carroDTOAssembler.toDTO(carro);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CarroDTO adicionar(@RequestBody CarroInput carroInput) {
		Carro carro = carroInputDiassembler.toDomainObject(carroInput);
		
		carro = carroService.salvar(carro);
		
		return carroDTOAssembler.toDTO(carro);
	}
	
}
