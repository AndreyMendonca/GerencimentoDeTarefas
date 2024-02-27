package com.projetoAndrey.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_painel")
public class Painel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String identificacao;
	
	@OneToMany(mappedBy = "painel")
	private List<Tarefa> Tarefas = new ArrayList<>();
	
	public Painel() {}

	public Painel(Long id, String identificacao) {
		super();
		this.id = id;
		this.identificacao = identificacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public List<Tarefa> getTarefas() {
		return Tarefas;
	}

}
