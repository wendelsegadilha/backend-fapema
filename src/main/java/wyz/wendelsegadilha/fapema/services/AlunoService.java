package wyz.wendelsegadilha.fapema.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import wyz.wendelsegadilha.fapema.domain.Aluno;
import wyz.wendelsegadilha.fapema.domain.dto.AlunoDTO;
import wyz.wendelsegadilha.fapema.domain.dto.AlunoUpdateDTO;
import wyz.wendelsegadilha.fapema.repositories.AlunoRepository;
import wyz.wendelsegadilha.fapema.services.exceptions.AlunoNotFoundException;

@Service
public class AlunoService {

	private final AlunoRepository repository;

	public AlunoService(AlunoRepository repository) {
		this.repository = repository;
	}

	public Aluno buscarPorId(Integer id) {
		Optional<Aluno> aluno = repository.findById(id);
		return aluno.orElseThrow(() -> new AlunoNotFoundException(
				"Aluno não encontrado! Id: " + id + ", Tipo " + Aluno.class.getName()));
	}

	public List<AlunoDTO> buscarTodos() {
		List<Aluno> alunos = repository.findAll();
		List<AlunoDTO> dtos = new ArrayList<>();
		for (Aluno aluno : alunos) {
			AlunoDTO dto = fromDTO(aluno);
			dtos.add(dto);
		}
		return dtos;
	}

	public Aluno salvar(Aluno aluno) {
		aluno.setId(null);
		return repository.save(aluno);
	}

	public void atualizar(Aluno aluno) {
		var obj = buscarPorId(aluno.getId());
		aluno.setImagem(obj.getImagem());
		repository.save(aluno);
	}

	public void excluir(Integer id) {
		buscarPorId(id);
		repository.deleteById(id);
	}

	public AlunoDTO fromDTO(Aluno obj) {
		AlunoDTO dto = new AlunoDTO();
		dto.setId(obj.getId());
		dto.setNome(obj.getNome());
		dto.setCpf(obj.getCpf());
		dto.setMatricula(obj.getMatricula());
		dto.setImagem(obj.getImagem());
		return dto;
	}

	public Aluno fromAluno(AlunoDTO dto) {
		Aluno aluno = new Aluno();
		aluno.setId(dto.getId());
		aluno.setNome(dto.getNome());
		aluno.setCpf(dto.getCpf());
		aluno.setMatricula(dto.getMatricula());
		aluno.setImagem(dto.getImagem());
		return aluno;
	}
	
	public Aluno fromAluno(AlunoUpdateDTO dto) {
		Aluno aluno = new Aluno();
		aluno.setId(dto.getId());
		aluno.setNome(dto.getNome());
		aluno.setCpf(dto.getCpf());
		aluno.setMatricula(dto.getMatricula());
		return aluno;
	}

}
