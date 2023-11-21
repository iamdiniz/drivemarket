package com.driver.api.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDTO {
	
	private Long id;
	private BigDecimal valor;
	private CarroReferenciaDTO carro;
	private ClienteReferenciaDTO cliente;
	private VendedorReferenciaDTO vendedor;

}
