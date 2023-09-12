package com.driver.domain.exception;

public class FabricanteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public FabricanteNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public FabricanteNaoEncontradoException(Long fabricanteId) {
		this(String.format("Não existe um fabricante com código %d", fabricanteId));
	}

}
