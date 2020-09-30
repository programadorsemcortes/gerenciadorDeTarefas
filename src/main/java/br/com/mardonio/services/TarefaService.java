package br.com.mardonio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public Tarefa update(Tarefa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Tarefa> findAll(){
		return repo.findAll();
	}
	
	public Page<Tarefa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
