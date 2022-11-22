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

	import br.edu.ifms.escolalp.Dto.TurmaDto;
	import br.edu.ifms.escolalp.model.Turma;
	import br.edu.ifms.escolalp.service.TurmaService;

	@RestController
	@RequestMapping(value = "/turma")
	public class TurmaResource {
		
		@Autowired
		private TurmaService turma;
		
		@RequestMapping(value="/{id}", method = RequestMethod.GET)
		public ResponseEntity<Turma> find(@PathVariable Integer id) {		
			Turma obj = turma.buscarPorId(id);
			return ResponseEntity.ok().body(obj);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody TurmaDto objDto) {
			Turma obj = turma.fromDto(objDto);
			obj = turma.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@Valid @RequestBody TurmaDto objDto, @PathVariable Integer id) {
			Turma obj = turma.fromDto(objDto);
			obj.setId(id);
			obj = turma.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		
		@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
		//@RequestBody Turma obj, @PathVariable(value = "id") Long noteId
		public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws Exception{
			turma.delete(id);
			return ResponseEntity.noContent().build();
		}
		public ResponseEntity<Void> delete(@RequestBody Turma obj,@PathVariable Integer id) throws Exception{
			turma.delete(id);
			return ResponseEntity.noContent().build();
		}
			
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<TurmaDto>> findAll() {		
			List<Turma> list = turma.findAll();
			List<TurmaDto> listDto = list.stream().map(obj -> new TurmaDto(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}

	}

