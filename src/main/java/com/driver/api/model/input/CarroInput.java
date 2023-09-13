package com.driver.api.model.input;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarroInput {
	
	private String modelo;
	private Integer ano;
	private BigDecimal preco;
	private Double potencia;
	private String cor;
	private String carroceria;
	private String combustivel;
    private String cambio;
	private String placa;
	private String numeroChassi;
    private String descricao;
	private FabricanteIdInput fabricante; // Classe criada para referenciar o id do fabricante.

}
