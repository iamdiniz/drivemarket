package com.driver.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ErrorType {

	NOT_FOUND("/recurso-nao-encontrado", "Recurso não encontrado");
	
	private String title;
	private String uri;
	
	ErrorType(String path, String title) {
		this.uri = "https://drivemarket.com.br" + path;
		this.title = title;
	}
	
}
