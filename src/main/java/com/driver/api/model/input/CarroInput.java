package com.driver.api.model.input;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarroInput {
	
	@NotBlank
	private String modelo;
	
	@NotNull
	@PositiveOrZero
	private Integer ano;
	
	@NotNull
	@PositiveOrZero
	private BigDecimal preco;
	
	@NotNull
	@PositiveOrZero
	private Double potencia;
	
	@NotBlank
	private String cor;
	
	@NotBlank
	private String carroceria;
	
	@NotBlank
	private String combustivel;
	
	@NotBlank
    private String cambio;
	
	@NotBlank
	private String placa;
	
	@NotBlank
	private String numeroChassi;
	
	@NotBlank
    private String descricao;
	
	@Valid
	@NotNull
	private FabricanteIdInput fabricante; // Classe criada para referenciar o id do fabricante.

}
