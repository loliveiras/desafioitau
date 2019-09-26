package br.com.desafioitau.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioitau.controller.TarefaController;
import br.com.desafioitau.entity.Tarefa;

@RestController
@RequestMapping("/services/tarefa")
public class TarefaService {
	
	@Autowired
	private TarefaController tarefaController;
	
	@PostMapping()
	public ResponseEntity<String> saveTarefa(@Valid @RequestBody Tarefa tarefa) {
		if(!tarefaController.validateStatus(tarefa))
			return new ResponseEntity<>("Invalid Value Status", HttpStatus.PRECONDITION_FAILED);
		
		tarefaController.saveTarefa(tarefa);
		return new ResponseEntity<>("Success Create Task", HttpStatus.OK);
	}

	@GetMapping()	
	public List<Tarefa> listTarefas() {
		List<Tarefa> tarefas = tarefaController.listAllTarefa();
		return tarefas;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateTarefa(@PathVariable(value = "id") Integer id, @Valid @RequestBody Tarefa tarefa) {
		if(!tarefaController.validateStatus(tarefa))
			return new ResponseEntity<>("Invalid Value Status", HttpStatus.PRECONDITION_FAILED);
				
		tarefaController.updateTarefa(id, tarefa);
		return new ResponseEntity<>("Success Update Task", HttpStatus.OK);
	}
}