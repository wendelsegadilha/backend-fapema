package wyz.wendelsegadilha.fapema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import wyz.wendelsegadilha.fapema.domain.Aluno;
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
		return aluno.orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado! Id: " + id + ", Tipo " + Aluno.class.getName()));
	}
	
	public List<Aluno> buscarTodos() {
		return repository.findAll();
	}

	public Aluno salvar(Aluno aluno) {
		aluno.setId(null);
		return repository.save(aluno);
	}

	public void atualizar(Aluno aluno) {
		buscarPorId(aluno.getId());
		repository.save(aluno);
	}

	public void excluir(Integer id) {
		buscarPorId(id);
		repository.deleteById(id);
	}

}
