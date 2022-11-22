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

	import br.edu.ifms.escolalp.Dto.EscolaDto;
	import br.edu.ifms.escolalp.model.Escola;
	import br.edu.ifms.escolalp.service.EscolaService;

	@RestController
	@RequestMapping(value = "/escola")
	public class EscolaResource {
		
		@Autowired
		private EscolaService escola;
		
		@RequestMapping(value="/{id}", method = RequestMethod.GET)
		public ResponseEntity<Escola> find(@PathVariable Integer id) {		
			Escola obj = escola.buscarPorId(id);
			return ResponseEntity.ok().body(obj);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody EscolaDto objDto) {
			Escola obj = escola.fromDto(objDto);
			obj = escola.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@Valid @RequestBody EscolaDto objDto, @PathVariable Integer id) {
			Escola obj = escola.fromDto(objDto);
			obj.setId(id);
			obj = escola.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		
		@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
		//@RequestBody Escola obj, @PathVariable(value = "id") Long noteId
		public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws Exception{
			escola.delete(id);
			return ResponseEntity.noContent().build();
		}
		public ResponseEntity<Void> delete(@RequestBody Escola obj,@PathVariable Integer id) throws Exception{
			escola.delete(id);
			return ResponseEntity.noContent().build();
		}
			
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<EscolaDto>> findAll() {		
			List<Escola> list = escola.findAll();
			List<EscolaDto> listDto = list.stream().map(obj -> new EscolaDto(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}

	}
	
