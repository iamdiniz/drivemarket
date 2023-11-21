package com.driver.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.input.ConcessionariaInput;
import com.driver.domain.model.Concessionaria;

@Component
public class ConcessionariaInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Concessionaria toDomainObject(ConcessionariaInput concessionariaInput) {
		return modelMapper.map(concessionariaInput, Concessionaria.class);
	}
	
	public void copyToDomainObject(ConcessionariaInput concessionariaInput, Concessionaria concessionaria) {
		modelMapper.map(concessionariaInput, concessionaria);
	}
	
}
