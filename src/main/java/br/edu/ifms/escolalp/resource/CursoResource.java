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

import br.edu.ifms.escolalp.Dto.CursoDto;
import br.edu.ifms.escolalp.model.Curso;
import br.edu.ifms.escolalp.service.CursoService;



@RestController
@RequestMapping(value = "/curso")
public class CursoResource {
	
	@Autowired
	private CursoService curso;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> find(@PathVariable Integer id) {		
		Curso obj = curso.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CursoDto objDto) {
		Curso obj = curso.fromDto(objDto);
		obj = curso.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CursoDto objDto, @PathVariable Integer id) {
		Curso obj = curso.fromDto(objDto);
		obj.setId(id);
		obj = curso.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Curso obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws Exception{
		curso.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Curso obj,@PathVariable Integer id) throws Exception{
		curso.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CursoDto>> findAll() {		
		List<Curso> list = curso.findAll();
		List<CursoDto> listDto = list.stream().map(obj -> new CursoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
