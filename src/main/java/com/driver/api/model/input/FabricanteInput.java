package com.driver.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FabricanteInput {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String paisOrigem;
	
	@NotNull
	@PositiveOrZero
	private Integer anoFundacao;

}
