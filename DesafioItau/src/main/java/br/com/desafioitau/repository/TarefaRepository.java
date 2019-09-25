package br.com.desafioitau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafioitau.entity.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Integer> {
 
	@Query("select t from Tarefa t")
    public List<Tarefa> list();
	
	@Query("select t from Tarefa t where t.id=:id")
    public Tarefa find(@Param(value = "id") Integer id);
}