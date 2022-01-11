package wyz.wendelsegadilha.fapema.services.exceptions;

public class ArmazenamentoArquivoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ArmazenamentoArquivoException(String msg) {
		super(msg);
	}
	
	public ArmazenamentoArquivoException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
