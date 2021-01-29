package br.com.zup.casadocodigo.modelo.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.modelo.Estado;
import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.repository.PaisRepository;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class EstadoForm {

	@NotBlank 
	@UniqueValue(domainClass = Estado.class, fieldName = "nome",
	message = "O Estado informado já foi cadastrado, por favor informar outro")
	private String nome;

	@NotNull 
	private Long idPais;

	public EstadoForm() {

	}

	public EstadoForm(Estado estado) {
		this.nome = estado.getNome();
		this.idPais = estado.getPais().getId();
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado converter(PaisRepository paisRepository) {
		Optional<Pais> pais = paisRepository.findById(idPais);
		return new Estado(nome, pais.get());
	}

}
