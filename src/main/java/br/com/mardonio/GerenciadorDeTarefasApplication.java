package br.com.mardonio;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mardonio.domain.Tarefa;
import br.com.mardonio.repositories.TarefaRepository;

@SpringBootApplication
public class GerenciadorDeTarefasApplication implements CommandLineRunner{

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeTarefasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date d1 = new Date(System.currentTimeMillis());
		
		Tarefa t1 = new Tarefa(null, "Primeira Tarefa", 1, "Criar spring", d1, d1, null, null, 0);
		Tarefa t2 = new Tarefa(null, "Segunda Tarefa", 1, "Criar BD", d1, d1, null, null, 0);
		
		tarefaRepository.saveAll(Arrays.asList(t1,t2));
	}
	

}
