package wyz.wendelsegadilha.fapema.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import wyz.wendelsegadilha.fapema.domain.Aluno;
import wyz.wendelsegadilha.fapema.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	private final AlunoRepository repository;
	
	public AlunoService(AlunoRepository repository) {
		this.repository = repository;
	}
	
	public Aluno buscarPorId(Integer id) {
		Optional<Aluno> aluno = repository.findById(id);
		return aluno.orElse(null);
	}

}
