package br.edu.ifms.escolalp.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.escolalp.model.Turma;
import br.edu.ifms.escolalp.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	private TurmaRepository repo;
	
	public Turma buscarPorId(Integer id) {
		Optional<Turma> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName(), null));		
	}
	
	public Turma insert (Turma obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Turma update(Turma obj) {
		Turma newObj = buscarPorId(obj.getId());
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

	public List<Turma> findAll() {
			
		return repo.findAll();
	}
	
	

	
	private void updateData(Turma newObj, Turma obj) {
		newObj.setNome(obj.getNome());
		newObj.setTurma(obj.getTurma());
	}

}

