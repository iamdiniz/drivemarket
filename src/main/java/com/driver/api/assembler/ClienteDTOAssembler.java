package com.driver.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.ClienteDTO;
import com.driver.domain.model.Cliente;

@Component
public class ClienteDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteDTO toDTO(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDTO.class);
	}
	
	public List<ClienteDTO> toCollectionDTO(List<Cliente> clientes) {
		return clientes.stream()
				.map(cliente -> toDTO(cliente))
				.collect(Collectors.toList());
	}

}
