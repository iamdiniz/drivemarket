package com.driver.domain.exception;

public class CarroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CarroNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public CarroNaoEncontradoException(Long carroId) {
		this(String.format("Não existe um carro com código", carroId));
	}

}
