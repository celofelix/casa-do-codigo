package br.com.zup.casadocodigo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String nome;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Pais pais;

	public Estado() {

	}

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public boolean pertenceAPais(Pais pais) {
        return this.pais.equals(pais);
    }

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}

}
