package br.com.desafioitau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioitau.dao.TarefaDAO;
import br.com.desafioitau.entity.Tarefa;

@RestController
public class TarefaController {
	
	private final TarefaDAO dao;

	@Autowired
	public TarefaController(TarefaDAO dao) {
		this.dao = dao;
	}

	@PostMapping(value = "/novaTarefa")
	public ResponseEntity<Tarefa> createLivro(@RequestBody Tarefa tarefa) {
		dao.save(tarefa);
		return new ResponseEntity<>(tarefa, HttpStatus.CREATED);
	}

	@GetMapping("/tarefas/{id}")	
	public ResponseEntity<Tarefa> findLivro(Long id) {
		Tarefa tarefa = dao.find(id);

		if (null == tarefa) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tarefa>(tarefa, HttpStatus.OK);
	}
	
	@GetMapping("/tarefas")	
	public List<Tarefa> listTarefas() {
		List<Tarefa> tarefas = dao.list();

		return tarefas;
	}
}