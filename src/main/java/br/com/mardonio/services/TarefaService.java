package br.com.mardonio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mardonio.domain.Tarefa;
import br.com.mardonio.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repo;
	
	public Tarefa find(Integer id) {
		Optional<Tarefa> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
