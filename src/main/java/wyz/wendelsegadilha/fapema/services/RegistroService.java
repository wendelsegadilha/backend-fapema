package wyz.wendelsegadilha.fapema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wyz.wendelsegadilha.fapema.domain.Registro;
import wyz.wendelsegadilha.fapema.repositories.RegistroRepository;

@Service
public class RegistroService {
	
	@Autowired
	private RegistroRepository repository;

	public void salvar(Registro registro) {
		repository.save(registro);
	}
	

}
