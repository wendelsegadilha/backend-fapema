package wyz.wendelsegadilha.fapema.services.exceptions;

public class ArquivoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ArquivoNotFoundException(String msg) {
		super(msg);
	}
	
	public ArquivoNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
