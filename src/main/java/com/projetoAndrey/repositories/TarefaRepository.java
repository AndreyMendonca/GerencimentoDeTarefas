package com.projetoAndrey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoAndrey.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
