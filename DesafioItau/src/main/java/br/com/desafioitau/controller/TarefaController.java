package br.com.desafioitau.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.desafioitau.entity.Tarefa;
import br.com.desafioitau.repository.TarefaRepository;
import br.com.desafioitau.util.TarefaStatusEnum;

@RestController
@RequestMapping("/services/tarefa")
public class TarefaController {

	@Autowired
	private TarefaRepository repository;

	@PostMapping()
	public ResponseEntity<String> saveTarefa(@Valid @RequestBody Tarefa tarefa){
		if(!validateStatus(tarefa))
			return new ResponseEntity<>("Invalid Value Status", HttpStatus.PRECONDITION_FAILED);
		
		repository.save(tarefa);
		return new ResponseEntity<>("Success Create Task", HttpStatus.OK);
	}

	@GetMapping()	
	public List<Tarefa> listTarefas() {
		List<Tarefa> tarefas = repository.list();
		return tarefas;
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateTarefa(@PathVariable(value = "id") Integer id, @Valid @RequestBody Tarefa tarefa) {
		if(validateStatus(tarefa))
			return new ResponseEntity<>("Invalid Value Status", HttpStatus.PRECONDITION_FAILED);
		Optional<Tarefa> tarefas = repository.findById(id);

		tarefas.get().setNome(tarefa.getNome());
		tarefas.get().setStatus(tarefa.getStatus());
		repository.save(tarefas.get());
		return new ResponseEntity<>("Success Update Task", HttpStatus.OK);
	}
	
	public boolean validateStatus(Tarefa tarefa) {
		if(TarefaStatusEnum.STATUS_PENDING.getValue().equalsIgnoreCase(tarefa.getStatus()) 
				|| TarefaStatusEnum.STATUS_COMPLETED.getValue().equalsIgnoreCase(tarefa.getStatus()))
			return true;
			
		return false;
	}
}