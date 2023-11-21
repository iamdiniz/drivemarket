package com.driver.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.ConcessionariaDTO;
import com.driver.domain.model.Concessionaria;

@Component
public class ConcessionariaDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ConcessionariaDTO toDTO(Concessionaria concessionaria) {
		return modelMapper.map(concessionaria, ConcessionariaDTO.class);
	}
	
	public List<ConcessionariaDTO> toCollectionDTO(List<Concessionaria> concessionarias) {
		return concessionarias.stream()
					.map(Concessionaria -> toDTO(Concessionaria))
					.collect(Collectors.toList());
	}

}
