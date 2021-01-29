package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.modelo.form.PaisForm;
import br.com.zup.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid PaisForm pais) {

		Pais novoPais = pais.toModel(pais);
		paisRepository.save(novoPais);

		return ResponseEntity.ok().build();
	}

}
