package wyz.wendelsegadilha.fapema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wyz.wendelsegadilha.fapema.domain.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer>{

}
