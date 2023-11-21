package com.driver.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	private Long id;
	private String nome;
	private String email;	
    private String estado;
	private String pais;
	private String cidade;
    private String endereco;
    private String telefone;
	
}
