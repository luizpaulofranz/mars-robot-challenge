/**
 * Exception handler to catch our custom Exceptions.
 * Just returns a BAD_REQUEST response with a proper error message to the user.
 */

package com.challenge.evoluum.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.challenge.evoluum.domain.exceptions.CommandInvalidExcpetion;
import com.challenge.evoluum.domain.exceptions.OutOfBorderExcpetion;

@ControllerAdvice
public class EvoluumExceptionHandler {
	
	@ExceptionHandler({OutOfBorderExcpetion.class, CommandInvalidExcpetion.class})
	public ResponseEntity<String> handleLivroNaoEncontradoException(Exception e,
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}
