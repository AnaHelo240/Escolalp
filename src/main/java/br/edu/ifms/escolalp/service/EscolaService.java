package br.edu.ifms.escolalp.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.escolalp.Dto.EscolaDto;
import br.edu.ifms.escolalp.model.Escola;
import br.edu.ifms.escolalp.repository.EscolaRepository;

@Service
public class EscolaService {

		@Autowired
		private EscolaRepository repo;
		
		public Escola buscarPorId(Integer id) {
			Optional<Escola> obj = repo.findById(id); 
			return obj.orElseThrow(() -> new ObjectNotFoundException( 
					 "Objeto não encontrado! Id: " + id + ", Tipo: " + Escola.class.getName(), null));		
		}
		
		public Escola insert (Escola obj) {
			obj.setId(null);
			return repo.save(obj);
			
		}

		public Escola update(Escola obj) {
			Escola newObj = buscarPorId(obj.getId());
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

		public List<Escola> findAll() {
				
			return repo.findAll();
		}
		
		

		
		private void updateData(Escola newObj, Escola obj) {
			newObj.setNome(obj.getNome());
			newObj.setCnpj(obj.getCnpj());
			
		}

		public Escola fromDto(EscolaDto objDto) {
			
			return new Escola(objDto.getId(), objDto.getNome(), objDto.getCnpj());
			
			
		}

	}



