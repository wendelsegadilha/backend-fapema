package wyz.wendelsegadilha.fapema.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wyz.wendelsegadilha.fapema.domain.Aluno;
import wyz.wendelsegadilha.fapema.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	private final AlunoService service;

	public AlunoController(AlunoService service) {
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Aluno aluno = service.buscarPorId(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping
	public ResponseEntity<?> bucarTodos() {
		List<Aluno> alunos = service.buscarTodos();
		return ResponseEntity.ok().body(alunos);
	}

}
