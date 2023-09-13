package com.driver.api.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarroDTO {

	private Long id;
	private String modelo;
	private Integer ano;
	private BigDecimal preco;
	private Double potencia;
	private String cor;
	private String carroceria;
	private String combustivel;
	private String cambio;
	private FabricanteDTO fabricante;
	
}
