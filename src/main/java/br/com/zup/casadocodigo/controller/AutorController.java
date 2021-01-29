package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.modelo.Autor;
import br.com.zup.casadocodigo.modelo.form.AutorForm;
import br.com.zup.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid AutorForm autor) {		
		Autor novoAutor = autor.toModel(autor);
		autorRepository.save(novoAutor);
		return ResponseEntity.ok().build();
	}

}
