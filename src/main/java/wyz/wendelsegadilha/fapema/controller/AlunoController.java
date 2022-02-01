package wyz.wendelsegadilha.fapema.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import wyz.wendelsegadilha.fapema.domain.Aluno;
import wyz.wendelsegadilha.fapema.domain.dto.AlunoDTO;
import wyz.wendelsegadilha.fapema.domain.dto.AlunoUpdateDTO;
import wyz.wendelsegadilha.fapema.services.AlunoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	private final AlunoService service;

	public AlunoController(AlunoService service) {
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> buscarPorId(@Valid @PathVariable Integer id) {
		Aluno aluno = service.buscarPorId(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> bucarTodos() {
		List<AlunoDTO> alunos = service.buscarTodos();
		return ResponseEntity.ok().body(alunos);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody AlunoDTO dto) {
		
		Aluno aluno = service.fromAluno(dto);
		aluno = service.salvar(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody AlunoUpdateDTO dto, @PathVariable Integer id) {
		
		Aluno aluno = service.fromAluno(dto);
		aluno.setId(id);
		service.atualizar(aluno);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
