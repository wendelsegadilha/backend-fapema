package wyz.wendelsegadilha.fapema.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import wyz.wendelsegadilha.fapema.services.exceptions.AlunoNotFoundException;
import wyz.wendelsegadilha.fapema.services.exceptions.ArmazenamentoArquivoException;
import wyz.wendelsegadilha.fapema.services.exceptions.ArquivoNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(AlunoNotFoundException.class)
	public ResponseEntity<StandardError> alunoNotFound(AlunoNotFoundException e, HttpServletRequest req) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(ArmazenamentoArquivoException.class)
	public ResponseEntity<StandardError> armazenamentoArquivo(ArmazenamentoArquivoException e, HttpServletRequest req) {
		StandardError err = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}
	
	@ExceptionHandler(ArquivoNotFoundException.class)
	public ResponseEntity<StandardError> arquivoNotFoundException(ArquivoNotFoundException e, HttpServletRequest req) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
