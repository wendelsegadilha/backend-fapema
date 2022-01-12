package wyz.wendelsegadilha.fapema.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class AlunoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preencimento obrigatório")
	@Length(min = 5, max = 255, message = "O nome deve conter no mínimo 5 caracteres")
	private String nome;
	@NotEmpty(message = "Preencimento obrigatório")
	@CPF(message = "CPF inválido")
	private String cpf;
	@NotEmpty(message = "Preencimento obrigatório")
	private String matricula;
	private String imagem;
	
	public AlunoDTO() {
	}
	
	public AlunoDTO(Integer id, String nome, String cpf, String matricula, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.imagem = imagem;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoDTO other = (AlunoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
}
