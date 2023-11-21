package com.driver.domain.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@ManyToOne
    @JoinColumn(name="carro_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
    private Carro carro;
	
	@ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
	private Cliente cliente;
	
	@ManyToOne
    @JoinColumn(name="vendedor_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
    private Vendedor vendedor;

}
