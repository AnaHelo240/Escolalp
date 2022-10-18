package br.edu.ifms.escolalp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.escolalp.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
