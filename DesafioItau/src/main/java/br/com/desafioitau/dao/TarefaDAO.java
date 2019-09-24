package br.com.desafioitau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafioitau.entity.Tarefa;

@Repository
public interface TarefaDAO extends CrudRepository<Tarefa, Long> {
 
	@Query("select t from Tarefa t")
    public List<Tarefa> list();
	
	@Query("select t from Tarefa t where t.id=:id")
    public Tarefa find(@Param(value = "id") Long id);
}