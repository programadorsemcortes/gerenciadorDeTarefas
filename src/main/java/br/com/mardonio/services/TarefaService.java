package br.com.mardonio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mardonio.domain.Tarefa;
import br.com.mardonio.repositories.TarefaRepository;
import br.com.mardonio.services.exceptions.ObjectNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repo;
	
	public Tarefa find(Integer id) {
		Optional<Tarefa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tarefa.class.getName()));
	}
	
	public Tarefa insert(Tarefa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
}
