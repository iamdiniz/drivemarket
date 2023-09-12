package com.driver.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.input.CarroInput;
import com.driver.api.model.input.CarroUpdateInput;
import com.driver.domain.model.Carro;
import com.driver.domain.model.Fabricante;

@Component
public class CarroInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Carro toDomainObject(CarroInput carroInput) {
		return modelMapper.map(carroInput, Carro.class);
	}
	
	public void copyToDomainObject(CarroUpdateInput carroUpdateInput, Carro carro) {
		// Pra evitar identifier of an instance of ... was altered from x to y.
		carro.setFabricante(new Fabricante());
		
		modelMapper.map(carroUpdateInput, carro);
	}
	
}
