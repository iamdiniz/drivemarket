package com.driver.domain.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;
	
	public ClienteNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public ClienteNaoEncontradoException(Long clienteId) {
		this(String.format("Não existe um cliente com código %d", clienteId));
	}
	
}
