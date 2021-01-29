package br.com.zup.casadocodigo.modelo.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class PaisForm {

	@NotBlank 
	@UniqueValue(domainClass = Pais.class, fieldName = "nome",
	message = "País informado já foi cadastrado, por favor informar outro")
	private String nome;

	public PaisForm() {

	}

	public PaisForm(Pais pais) {
		this.nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel(PaisForm pais) {
		return new Pais(pais.getNome());
	}

}
