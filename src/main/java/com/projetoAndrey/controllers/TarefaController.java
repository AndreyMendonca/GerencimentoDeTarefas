package com.projetoAndrey.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetoAndrey.entities.Tarefa;
import com.projetoAndrey.services.TarefaService;


@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaService service;

	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll() {
		List<Tarefa> tarefas = service.findAll();
		return ResponseEntity.ok().body(tarefas);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
		Tarefa tarefa = service.findById(id);
		return ResponseEntity.ok().body(tarefa);
	}
	@PostMapping(value = "/insert")
	public ResponseEntity<Tarefa> insert(@RequestBody Tarefa tarefa){
		tarefa.setDataCadastro();
		tarefa.setConcluida(false);
		tarefa = service.insert(tarefa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(tarefa);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
