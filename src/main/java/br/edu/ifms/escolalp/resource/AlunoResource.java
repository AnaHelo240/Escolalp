package br.edu.ifms.escolalp.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.escolalp.Dto.AlunoDto;
import br.edu.ifms.escolalp.model.Aluno;
import br.edu.ifms.escolalp.service.AlunoService;

	@RestController
	@RequestMapping(value = "/aluno")
	public class AlunoResource {
	
	@Autowired
	private AlunoService aluno;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {		
		Aluno obj = aluno.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AlunoDto objDto) {
		Aluno obj = aluno.fromDto(objDto);
		obj = aluno.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AlunoDto objDto, @PathVariable Integer id) {
		Aluno obj = aluno.fromDto(objDto);
		obj.setId(id);
		obj = aluno.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Aluno obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws Exception{
		aluno.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Aluno obj,@PathVariable Integer id) throws Exception{
		aluno.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AlunoDto>> findAll() {		
		List<Aluno> list = aluno.findAll();
		List<AlunoDto> listDto = list.stream().map(obj -> new AlunoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
