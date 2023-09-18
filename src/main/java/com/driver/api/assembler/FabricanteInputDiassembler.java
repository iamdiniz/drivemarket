package com.driver.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.input.FabricanteInput;
import com.driver.domain.model.Fabricante;

@Component
public class FabricanteInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Fabricante toDomainObject(FabricanteInput fabricanteInput) {
		return modelMapper.map(fabricanteInput, Fabricante.class);
	}
	
	public void copyToDomainObject(FabricanteInput fabricanteInput, Fabricante fabricante) {
		modelMapper.map(fabricanteInput, fabricante);
	}
	
}
