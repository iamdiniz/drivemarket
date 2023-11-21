package com.driver.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.VendaDTO;
import com.driver.domain.model.Venda;

@Component
public class VendaDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public VendaDTO toDTO(Venda venda) {
		return modelMapper.map(venda, VendaDTO.class);
	}
	
	public List<VendaDTO> toCollectionDTO(List<Venda> vendas) {
		return vendas.stream()
				.map(venda -> toDTO(venda))
				.collect(Collectors.toList());
	}

}
