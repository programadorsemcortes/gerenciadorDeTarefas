package br.com.mardonio.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mardonio.domain.Tarefa;
import br.com.mardonio.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefasResource {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll() {
		List<Tarefa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> find(@PathVariable Integer id){
		Tarefa obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Tarefa obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Tarefa obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Tarefa>> findPage(
			@RequestParam(value = "page", defaultValue = "0" ) Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24" ) Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "titulo" ) String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC" ) String direction
			){
		Page<Tarefa> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
