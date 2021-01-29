package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.modelo.form.CompraForm;
import br.com.zup.casadocodigo.validacao.EstadoPertenceAoPaisValidator;
import br.com.zup.casadocodigo.validacao.PaisPossuiEstadosValidator;

@RestController
@RequestMapping("/compradores")
public class CompraController {
	
	@Autowired
	private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;
	
	@Autowired
	private PaisPossuiEstadosValidator paisPossuiEstadosValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoPertenceAoPaisValidator, paisPossuiEstadosValidator);
	}
	
	@PostMapping
	public String cadastrarCompra(@RequestBody @Valid CompraForm compra) {
		return compra.toString();
	}
}
