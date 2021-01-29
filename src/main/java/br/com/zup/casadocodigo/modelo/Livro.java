package br.com.zup.casadocodigo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String titulo;

	@Column(length = 500)
	private String sinopse;

	@Column(nullable = false)
	private String sumario;

	@Column(precision = 11, scale = 2)
	private BigDecimal preco;

	@Min(100)
	@Column(nullable = false)
	private int paginas;

	@Column(nullable = false, unique = true)
	private String isbn;

	@Future
	@Column(nullable = false)
	private LocalDate dataPublicacao;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Autor autor;
	
	public Livro() {
		
	}

	public Livro(String titulo, String sinopse, String sumario, @Min(20) BigDecimal preco, @Min(100) int paginas,
			String isbn, @Future LocalDate dataPublicacao, Autor autor, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
