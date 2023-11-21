package com.driver.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.input.ClienteInput;
import com.driver.domain.model.Cliente;

@Component
public class ClienteInputDiassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Cliente toDomainObject(ClienteInput clienteInput) {
		return modelMapper.map(clienteInput, Cliente.class);
	}
	
	public void copyToDomainObject(ClienteInput clienteInput, Cliente cliente) {
		modelMapper.map(clienteInput, cliente);
	}

}
