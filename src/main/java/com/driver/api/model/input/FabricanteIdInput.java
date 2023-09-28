package com.driver.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FabricanteIdInput {

	@NotNull
	private Long id;
	
}
