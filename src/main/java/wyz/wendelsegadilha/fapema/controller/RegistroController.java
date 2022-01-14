package wyz.wendelsegadilha.fapema.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wyz.wendelsegadilha.fapema.domain.Aluno;
import wyz.wendelsegadilha.fapema.domain.Registro;
import wyz.wendelsegadilha.fapema.services.AlunoService;
import wyz.wendelsegadilha.fapema.services.RegistroService;

@RestController
@RequestMapping("/registros")
public class RegistroController {
	
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private RegistroService registroService;
	
	@GetMapping("registrar/{id}")
	public ResponseEntity<Void> registrar(@PathVariable Integer id) {
		Aluno buscarPorId = alunoService.buscarPorId(id);
		
		Registro registro = new Registro();
		registro.setAluno(buscarPorId);
		registro.setDataHora(LocalDateTime.now());
		registroService.salvar(registro);
		
		return ResponseEntity.ok().build();
		
	
	}
}
