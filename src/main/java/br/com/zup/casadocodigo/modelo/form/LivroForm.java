package br.com.zup.casadocodigo.modelo.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.modelo.Autor;
import br.com.zup.casadocodigo.modelo.Categoria;
import br.com.zup.casadocodigo.modelo.Livro;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import br.com.zup.casadocodigo.validacao.ExistID;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class LivroForm {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo",
	message = "O título informado já foi cadastrado, por favor informar outro")
	private String titulo;

	@NotBlank @Size(max = 500)
	private String sinopse;
	
	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@Min(100)
	@NotNull
	private int paginas;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", 
	message = "ISBN informado já foi cadastrado, por favor informar outro")
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	@NotNull
	@ExistID(domainClass = Categoria.class, fieldName = "id", 
	message = "A cateroria informada ainda não foi cadastrada, por favor informar outra")	
	private Long idCategoria;

	@NotNull
	@ExistID(domainClass = Autor.class, fieldName = "id",
	message = "O(a) Autor(a) informado(a) ainda não foi cadastrado(a), por favor informar outro(a)")
	private Long idAutor;
	
	public LivroForm() {
		
	}

	public LivroForm(Livro livro) {
		this.titulo = livro.getTitulo();
		this.sinopse = livro.getSinopse();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.idAutor = livro.getAutor().getId();
		this.idCategoria = livro.getCategoria().getId();
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

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Optional<Autor> autor = autorRepository.findById(idAutor);
		Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);		
		return new Livro(titulo, sinopse, sumario, preco, paginas, isbn, dataPublicacao, autor.get(), categoria.get());
	}
	
	
}
