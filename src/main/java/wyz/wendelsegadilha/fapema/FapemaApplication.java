package wyz.wendelsegadilha.fapema;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import wyz.wendelsegadilha.fapema.domain.Aluno;
import wyz.wendelsegadilha.fapema.repositories.AlunoRepository;

@SpringBootApplication
public class FapemaApplication implements CommandLineRunner{

	@Autowired
	private AlunoRepository alunoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FapemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno aluno01 = new Aluno(null, "Felipe Corte Real", "22608948103", "20201ENG.SIN00001"); 
		Aluno aluno02 = new Aluno(null, "Fernanda Helena Galvão", "64421153214", "20201ENG.SIN00002"); 
		Aluno aluno03 = new Aluno(null, "Sophia Silva Teixeira", "43247439757", "20201ENG.SIN00003"); 
		alunoRepository.saveAll(Arrays.asList(aluno01, aluno02, aluno03));
	
	}

}
