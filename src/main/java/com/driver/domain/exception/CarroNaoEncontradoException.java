package com.driver.domain.exception;

public class CarroNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public CarroNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public CarroNaoEncontradoException(Long carroId) {
		this(String.format("Não existe um carro com código %d", carroId));
	}

}
