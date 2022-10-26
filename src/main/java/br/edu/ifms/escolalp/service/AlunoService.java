package br.edu.ifms.escolalp.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.escolalp.model.Aluno;
import br.edu.ifms.escolalp.repository.AlunoRepository;


@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repo;
	
	public Aluno buscarPorId(Integer id) {
		Optional<Aluno> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName(), null));		
	}
	
	public Aluno insert (Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Aluno update(Aluno obj) {
		Aluno newObj = buscarPorId(obj.getId());
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

	public List<Aluno> findAll() {
			
		return repo.findAll();
	}
	
	private void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setIdade(obj.getIdade());
		newObj.setSexo(obj.getSexo());
	}

}

