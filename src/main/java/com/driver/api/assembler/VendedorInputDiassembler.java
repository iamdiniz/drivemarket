package com.driver.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.input.VendedorInput;
import com.driver.domain.model.Vendedor;

@Component
public class VendedorInputDiassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Vendedor toDomainObject(VendedorInput vendedorInput) {
		return modelMapper.map(vendedorInput, Vendedor.class);
	}
	
	public void copyToDomainObject(VendedorInput vendedorInput, Vendedor vendedor) {
		modelMapper.map(vendedorInput, vendedor);
	}
	
}
