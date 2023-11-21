package com.driver.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driver.api.model.input.VendaInput;
import com.driver.domain.model.Carro;
import com.driver.domain.model.Cliente;
import com.driver.domain.model.Venda;
import com.driver.domain.model.Vendedor;

@Component
public class VendaInputDiassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Venda toDomainObject(VendaInput vendaInput) {
		return modelMapper.map(vendaInput, Venda.class);
	}
	
	public void copyToDomainObject(VendaInput vendaInput, Venda venda) {
		venda.setCarro(new Carro());
		venda.setCliente(new Cliente());
		venda.setVendedor(new Vendedor());
		modelMapper.map(vendaInput, venda);
	}

}
