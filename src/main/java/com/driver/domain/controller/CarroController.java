package com.driver.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.domain.model.Carro;
import com.driver.domain.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;
	
	@GetMapping
	public List<Carro> findAll() {
		return carroRepository.findAll();
	}
	
}
