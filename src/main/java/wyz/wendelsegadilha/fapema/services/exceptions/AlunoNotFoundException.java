package wyz.wendelsegadilha.fapema.services.exceptions;

public class AlunoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AlunoNotFoundException(String msg) {
		super(msg);
	}
	
	public AlunoNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
