package com.driver.api.model.input;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VendedorInput {
	
	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	private String email;
	
	@CPF
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cargo;
	
}
