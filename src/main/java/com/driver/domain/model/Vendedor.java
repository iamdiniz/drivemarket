package com.driver.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Email
	@Column(nullable = false)
	private String email;
	
	@org.hibernate.validator.constraints.br.CPF
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String cargo;
	
	@JsonIgnoreProperties(value = {"venda"}, allowSetters=true)
	@OneToMany(mappedBy="vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venda> vendas;

}
