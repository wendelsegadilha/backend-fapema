package wyz.wendelsegadilha.fapema.domain;

import java.io.Serializable;

public class Arquivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Arquivo() {
	}
	
	public Arquivo(String nome, String uriDownload, String tipo, Long tamanho) {
		super();
		this.nome = nome;
		this.uriDownload = uriDownload;
		this.tipo = tipo;
		this.tamanho = tamanho;
	}

	private String nome;
	private String uriDownload;
	private String tipo;
	private Long tamanho;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUriDownload() {
		return uriDownload;
	}
	public void setUriDownload(String uriDownload) {
		this.uriDownload = uriDownload;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getTamanho() {
		return tamanho;
	}
	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}
	
}
