package br.com.zup.casadocodigo.modelo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.modelo.Autor;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class AutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank @Email 
	@UniqueValue(domainClass = Autor.class, fieldName = "email", 
	message = "O e-mail informado já foi cadastrado, por favor informar outro")
	private String email;
	
	@NotBlank @Size(max = 400)	
	private String descricao;
	
	public AutorForm() {
		
	}
	
	public AutorForm(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}
	
	public Autor toModel(AutorForm autor) {
		return new Autor (autor.getNome(), autor.getEmail(), autor.getDescricao());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
