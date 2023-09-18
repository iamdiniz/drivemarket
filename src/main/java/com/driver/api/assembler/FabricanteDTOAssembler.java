package com.driver.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.FabricanteDTO;
import com.driver.domain.model.Fabricante;

@Component
public class FabricanteDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public FabricanteDTO toDTO(Fabricante fabricante) {
		return modelMapper.map(fabricante, FabricanteDTO.class);
	}
	
	public List<FabricanteDTO> toCollectionDTO(List<Fabricante> fabricantes) {
		return fabricantes.stream()
					.map(fabricante -> toDTO(fabricante))
					.collect(Collectors.toList());
	}

}
