package br.com.desafioitau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioitau.dao.LivroDAO;
import br.com.desafioitau.entity.Livro;

@RestController
public class LivroController {
	
	private final LivroDAO dao;

	@Autowired
	public LivroController(LivroDAO dao) {
		this.dao = dao;
	}

	@PostMapping(value = "/books")
	public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
		dao.save(livro);
		return new ResponseEntity<>(livro, HttpStatus.CREATED);
	}

	@GetMapping("/books/{id}")	
	public ResponseEntity<Livro> findLivro(Long id) {
		Livro livro = dao.find(id);

		if (null == livro) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Livro>(livro, HttpStatus.OK);
	}
}