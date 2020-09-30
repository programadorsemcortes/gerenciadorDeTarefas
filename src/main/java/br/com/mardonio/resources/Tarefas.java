package br.com.mardonio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mardonio.domain.Tarefa;
import br.com.mardonio.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class Tarefas {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> find(@PathVariable Integer id){
		Tarefa obj = service.find(id);
		return ResponseEntity.ok(obj);
	}

}
