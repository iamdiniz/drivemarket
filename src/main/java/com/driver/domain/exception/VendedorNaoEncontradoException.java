package com.driver.domain.exception;

public class VendedorNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public VendedorNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public VendedorNaoEncontradoException(Long vendedorId) {
		this(String.format("Não existe um vendedor com código %d", vendedorId));
	}
	
}
