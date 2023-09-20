package com.driver.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FabricanteInput {
	
	@NotBlank
	private String nome;
	
	private String paisOrigem;
	private Integer anoFundacao;

}
