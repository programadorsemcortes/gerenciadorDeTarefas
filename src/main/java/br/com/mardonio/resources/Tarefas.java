package br.com.mardonio.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mardonio.domain.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class Tarefas {
	
	@GetMapping
	public List<Tarefa> listar() {
		Date agora = new Date(System.currentTimeMillis());
		Tarefa t1 = new Tarefa(1, "Titulo", 1, "Fazer algo", agora, agora, null, null, 0);
		Tarefa t2 = new Tarefa(2, "Titulo 2", 1, "Fazer algo 2", agora, agora, null, null, 0);
		
		List<Tarefa> lista = new ArrayList<>();
		lista.add(t1);
		lista.add(t2);
		return lista;
	}

}
