package com.driver.api.model.input;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteInput {
	
	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	private String email;
	
	@CPF
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String pais;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
    private String endereco;
    
	@NotBlank
    private String telefone;

}
