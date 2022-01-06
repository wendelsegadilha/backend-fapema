package wyz.wendelsegadilha.fapema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wyz.wendelsegadilha.fapema.domain.Aluno;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@GetMapping
	public List<Aluno> litar() {
		List<Aluno> lista = new ArrayList<>();
		Aluno aluno1 = new Aluno(1, "Jorge Joaquim da Cunha", "93160853497", "20201ENG.SIN0001");
		Aluno aluno2 = new Aluno(1, "Henry Sebastião Silveira", "13826242394", "20201ENG.SIN0002");
		lista.add(aluno1);
		lista.add(aluno2);
		return lista;
	}

}
