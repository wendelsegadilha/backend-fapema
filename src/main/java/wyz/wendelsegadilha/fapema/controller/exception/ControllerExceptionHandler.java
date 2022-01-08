package wyz.wendelsegadilha.fapema.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import wyz.wendelsegadilha.fapema.services.exceptions.AlunoNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(AlunoNotFoundException.class)
	public ResponseEntity<StandardError> alunoNotFound(AlunoNotFoundException e, HttpServletRequest req) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
