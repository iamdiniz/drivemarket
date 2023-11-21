package com.driver.domain.exception;

public class ConcessionariaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ConcessionariaNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public ConcessionariaNaoEncontradaException(Long concessionariaId) {
		this(String.format("Não existe uma concessionaria com código %d", concessionariaId));
	}

}
