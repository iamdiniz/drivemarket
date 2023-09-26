package com.driver.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.CarroByIdDTO;
import com.driver.api.model.CarroDTO;
import com.driver.domain.model.Carro;

@Component
public class CarroDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CarroDTO toDTO(Carro carro) {
		return modelMapper.map(carro, CarroDTO.class);
	}
	
	public CarroByIdDTO toByIdDTO(Carro carro) {
		return modelMapper.map(carro, CarroByIdDTO.class);
	}
	
	public List<CarroDTO> toCollectionDTO(List<Carro> carros) {
		return carros.stream()
					.map(carro -> toDTO(carro))
					.collect(Collectors.toList());
	}

}
