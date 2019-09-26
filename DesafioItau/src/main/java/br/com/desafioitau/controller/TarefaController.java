package br.com.desafioitau.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.desafioitau.entity.Tarefa;
import br.com.desafioitau.repository.TarefaRepository;
import br.com.desafioitau.util.TarefaStatusEnum;

@Component
public class TarefaController {

	@Autowired
	private TarefaRepository repository;

	public Tarefa saveTarefa(@RequestBody Tarefa tarefa) {
		repository.save(tarefa);
		return tarefa;
	}

	public List<Tarefa> listAllTarefa() {
		List<Tarefa> tarefas = repository.list();
		return tarefas;
	}

	public Tarefa updateTarefa(Integer id, Tarefa tarefa) {
		Optional<Tarefa> tarefas = repository.findById(id);

		tarefas.get().setNome(tarefa.getNome());
		tarefas.get().setStatus(tarefa.getStatus());
		final Tarefa tarefa1 = repository.save(tarefas.get());
		return tarefa1;
	}
	
	public boolean validateStatus(Tarefa tarefa) {
		if(TarefaStatusEnum.STATUS_PENDING.getValue().equalsIgnoreCase(tarefa.getStatus()) 
				|| TarefaStatusEnum.STATUS_COMPLETED.getValue().equalsIgnoreCase(tarefa.getStatus()))
			return true;
			
		return false;
	}
}