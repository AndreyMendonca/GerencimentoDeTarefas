package com.projetoAndrey.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAndrey.entities.Tarefa;
import com.projetoAndrey.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	public List<Tarefa> findAll(){
		List<Tarefa> tarefas = repository.findAll();
		return tarefas;
	}
	
	public Tarefa findById(Long id) {
		Optional<Tarefa> tarefa = repository.findById(id);
		return tarefa.get();
	}
	
	public Tarefa insert(Tarefa tarefa) {
		return repository.save(tarefa);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
