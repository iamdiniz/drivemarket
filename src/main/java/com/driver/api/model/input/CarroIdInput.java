package com.driver.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CarroIdInput {
	
	@NotNull
	private Long id;
	
}
