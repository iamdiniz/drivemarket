package com.driver.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConcessionariaInput {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String pais;
	
	@NotBlank
	private String telefone;

}
