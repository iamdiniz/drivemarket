package com.driver.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ErrorType {

	NOT_FOUND("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTITY_IN_USE("/entidade-em-uso", "Entidade em uso"),
	BUSINESS_ERROR("/erro-negocio", "Violação de regra de negócio");
	
	private String title;
	private String uri;
	
	ErrorType(String path, String title) {
		this.uri = "https://drivemarket.com.br" + path;
		this.title = title;
	}
	
}
