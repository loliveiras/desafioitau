package br.com.desafioitau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafioitau.entity.Livro;

@Repository
public interface LivroDAO extends CrudRepository<Livro, Long> {
 
	@Query("select l from Livro l")
    public List<Livro> list();
	
	@Query("select l from Livro l where l.id=:id")
    public Livro find(@Param(value = "id") Long id);
}