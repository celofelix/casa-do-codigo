package br.com.zup.casadocodigo.modelo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.modelo.Estado;
import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.validacao.CpfOrCnpj;
import br.com.zup.casadocodigo.validacao.ExistID;

public class CompraForm {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfOrCnpj(groups = CompraForm.class, message = "Deve ser informado um CPF ou CNPJ válido")
	private String documento;

	@NotBlank
	private String telefone;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	private String cep;

	@NotNull
	@ExistID(domainClass = Pais.class, fieldName = "id", message = "O País informado ainda não está cadastrado, por favor informar outro")
	private Long idPais;

	@NotNull
	@ExistID(domainClass = Estado.class, fieldName = "id", message = "O Estado informado ainda não está cadastrado, por favor informar ourto")
	private Long idEstado;

	public CompraForm() {

	}

	public CompraForm( String email, String nome,  String sobrenome,
			 String documento,  String telefone,  String endereco,
			String complemento,  String cidade,  String cep,  Long idPais,
			 Long idEstado) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.idPais = idPais;
		this.idEstado = idEstado;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	@Override
	public String toString() {
		return "CompraForm [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", telefone=" + telefone + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade="
				+ cidade + ", cep=" + cep + ", idPais=" + idPais + ", idEstado=" + idEstado + "]";
	}
}
