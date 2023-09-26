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

import com.driver.api.assembler.CarroDTOAssembler;
import com.driver.api.assembler.CarroInputDiassembler;
import com.driver.api.model.CarroByIdDTO;
import com.driver.api.model.CarroDTO;
import com.driver.api.model.input.CarroInput;
import com.driver.api.model.input.CarroUpdateInput;
import com.driver.domain.model.Carro;
import com.driver.domain.repository.CarroRepository;
import com.driver.domain.service.CarroService;

import jakarta.validation.Valid;

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
	public CarroByIdDTO findById(@PathVariable Long carroId) {
		Carro carro = carroService.buscarOuFalhar(carroId);
		
		return carroDTOAssembler.toByIdDTO(carro);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CarroDTO create(@RequestBody @Valid CarroInput carroInput) {
		Carro carro = carroInputDiassembler.toDomainObject(carroInput);
		
		return carroDTOAssembler.toDTO(carro = carroService.save(carro));
	}
	
	@PutMapping("/{carroId}")
	public CarroDTO update(@PathVariable Long carroId,
			@RequestBody @Valid CarroUpdateInput carroUpdateInput) {
		Carro carroAtual = carroService.buscarOuFalhar(carroId);
		
		carroInputDiassembler.copyToDomainObject(carroUpdateInput, carroAtual);
		
		return carroDTOAssembler.toDTO(carroService.save(carroAtual));
	}
	
	@DeleteMapping("/{carroId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long carroId) {
		carroService.delete(carroId);
	}
	
}
