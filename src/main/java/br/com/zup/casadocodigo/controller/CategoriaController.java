package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.modelo.Categoria;
import br.com.zup.casadocodigo.modelo.form.CategoriaForm;
import br.com.zup.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	
	@PostMapping
	public ResponseEntity<Void> cadastrar (@RequestBody @Valid CategoriaForm categoria) {
		Categoria novaCategoria = categoria.toModel(categoria);
		categoriaRepository.save(novaCategoria);
		return ResponseEntity.ok().build();
	}

}
