package com.driver.api.model.input;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VendaInput {
	
	@NotNull
	@PositiveOrZero
	private BigDecimal valor;
	
	@Valid
	@NotNull
    private CarroIdInput carro;
	
	@Valid
	@NotNull
    public ClienteIdInput cliente;
	
	@Valid
	@NotNull
    private VendedorIdInput vendedor;

}
