package br.edu.ifms.escolalp.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.escolalp.Dto.AlunoDto;
import br.edu.ifms.escolalp.Dto.CursoDto;
import br.edu.ifms.escolalp.model.Aluno;
import br.edu.ifms.escolalp.model.Curso;
import br.edu.ifms.escolalp.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repo;
	
	public Curso buscarPorId(Integer id) {
		Optional<Curso> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Curso.class.getName(), null));		
	}
	
	public Curso insert (Curso obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Curso update(Curso obj) {
		Curso newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) throws Exception {
	
		buscarPorId(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new Exception("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Curso> findAll() {
			
		return repo.findAll();
	}
	
	

	
	private void updateData(Curso newObj, Curso obj) {
		newObj.setNome(obj.getNome());
		newObj.setAnoDuracao(obj.getAnoDuracao());
		
	}

	public Curso fromDto(CursoDto objDto) {
		return new Curso(objDto.getId(), objDto.getNome(), objDto.getAnoDuracao());
	}
	
}

