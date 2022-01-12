package wyz.wendelsegadilha.fapema;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import wyz.wendelsegadilha.fapema.config.ArmazenamentoArquivoConfig;

@SpringBootApplication
@EnableConfigurationProperties({ArmazenamentoArquivoConfig.class})
public class FapemaApplication implements CommandLineRunner{

	//@Autowired
	//private AlunoRepository alunoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FapemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Aluno aluno01 = new Aluno(null, "Bill Gates", "22608948103", "20201ENG.SIN00001", ""); 
		Aluno aluno02 = new Aluno(null, "Elon Musk", "64421153214", "20201ENG.SIN00002", ""); 
		Aluno aluno03 = new Aluno(null, "Jack Ma", "43247439757", "20201ENG.SIN00003", ""); 
		alunoRepository.saveAll(Arrays.asList(aluno01, aluno02, aluno03));
		*/

	}

}
