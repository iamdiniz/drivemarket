package com.driver.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.driver.domain.exception.EntidadeEmUsoException;
import com.driver.domain.exception.EntidadeNaoEncontradaException;
import com.driver.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	public static final String MSG_ERRO_GENERICA_USUARIO_FINAL
	= "Ocorreu um erro interno inesperado no sistema. Tente novamente e se o problema"
			+ " persistir, entre em contato com o administrador do sistema";

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleEntidadeNaoEncontrada(
			EntidadeNaoEncontradaException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorType errorType = ErrorType.NOT_FOUND;
		String detail = ex.getMessage();
		
		StandardError error = createProblemBuilder(status, errorType, detail).build();
		
		return handleExceptionInternal(ex, error, null, status, request);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> handleEntidadeEmUso(EntidadeEmUsoException ex,
			WebRequest request) {
		
		HttpStatus status = HttpStatus.CONFLICT;
		ErrorType errorType = ErrorType.ENTITY_IN_USE;
		String detail = ex.getMessage();
		
		StandardError error = createProblemBuilder(status, errorType, detail).build();
		
		return handleExceptionInternal(ex, error, null, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorType errorType = ErrorType.BUSINESS_ERROR;
		String detail = ex.getMessage();
		
		StandardError error = createProblemBuilder(status, errorType, detail).build();
		
		return handleExceptionInternal(ex, error, null, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorType errorType = ErrorType.INVALID_DATA;
		String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente";
		
		StandardError error = createProblemBuilder((HttpStatus) status, errorType, detail).build();
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			org.springframework.http.HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
		
		if (body == null) {
			body = StandardError.builder()
					.title(statusCode.toString())
					.status(statusCode.value())
					.build();
		} else if (body instanceof String) {
			body = StandardError.builder()
					.title((String) body)
					.status(statusCode.value())
					.build();
		}
		
		return super.handleExceptionInternal(ex, body, headers, statusCode, request);
	}

	private StandardError.StandardErrorBuilder createProblemBuilder(HttpStatus status,
						ErrorType errorType, String detail) {
		
		return StandardError.builder()
						.status(status.value())
						.type(errorType.getUri())
						.title(errorType.getTitle())
						.detail(detail);
	}
	
}
