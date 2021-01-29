package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.modelo.Estado;
import br.com.zup.casadocodigo.modelo.form.EstadoForm;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	PaisRepository paisRepository;

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid EstadoForm estado) {
		Estado novoEstado = estado.converter(paisRepository);
		estadoRepository.save(novoEstado);
		return ResponseEntity.ok().build();
	}

}
