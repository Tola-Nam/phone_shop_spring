package com.tola.dev.phoneShope.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
	private final String message;

}
