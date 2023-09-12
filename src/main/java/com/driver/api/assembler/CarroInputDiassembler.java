package com.driver.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.input.CarroInput;
import com.driver.domain.model.Carro;

@Component
public class CarroInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Carro toDomainObject(CarroInput carroInput) {
		return modelMapper.map(carroInput, Carro.class);
	}
	
}
