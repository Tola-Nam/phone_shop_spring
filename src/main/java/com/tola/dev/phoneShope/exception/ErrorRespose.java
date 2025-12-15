package com.tola.dev.phoneShope.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ErrorRespose {

	private HttpStatus status;
	private String message;
}
