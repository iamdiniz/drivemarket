package com.driver.api.model.input;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarroUpdateInput {

	private String modelo;
	private Integer ano;
	private BigDecimal preco;
	private Double potencia;
	private String cor;
	private String carroceria;
	private String combustivel;
    private String cambio;
    private String descricao;
	private FabricanteIdInput fabricante;
	
}
