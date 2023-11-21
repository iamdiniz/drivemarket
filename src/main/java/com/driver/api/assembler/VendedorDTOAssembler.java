package com.driver.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.VendedorDTO;
import com.driver.domain.model.Vendedor;

@Component
public class VendedorDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public VendedorDTO toDTO(Vendedor vendedor) {
		return modelMapper.map(vendedor, VendedorDTO.class);
	}
	
	public List<VendedorDTO> toCollectionDTO(List<Vendedor> vendedores) {
		return vendedores.stream()
				.map(vendedor -> toDTO(vendedor))
				.collect(Collectors.toList());
	}

}
