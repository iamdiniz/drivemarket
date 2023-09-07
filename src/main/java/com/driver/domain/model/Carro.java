package com.driver.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private Integer ano;
	
	@Column(nullable = false)
	private Double preco;
	
	@Column(nullable = false)
	private Double potencia;
	
	@Column(nullable = false)
	private String cor;
	
	@Column(nullable = false)
	private String carroceria;
	
	@Column(nullable = false)
	private String combustivel;
	
	@Column(nullable = false)
	private String cambio;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(name = "numero_chassi", nullable = false)
	private String numeroChassi;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "fabricante_id", nullable = false)
	private Fabricante fabricante;
	
}
