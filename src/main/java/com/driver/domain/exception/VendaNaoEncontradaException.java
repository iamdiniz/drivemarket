package com.driver.domain.exception;

public class VendaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public VendaNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public VendaNaoEncontradaException(Long vendaId) {
		this(String.format("Não existe uma venda com código %d", vendaId));
	}

}
