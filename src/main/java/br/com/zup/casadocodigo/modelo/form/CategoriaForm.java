package br.com.zup.casadocodigo.modelo.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.modelo.Categoria;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome",
	message = "Categoria informada já cadastrada, por favor informar outra")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria toModel(CategoriaForm categoria) {
		return new Categoria(categoria.getNome());
	}

}
