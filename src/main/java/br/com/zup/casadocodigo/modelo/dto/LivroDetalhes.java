package br.com.zup.casadocodigo.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.casadocodigo.modelo.Livro;

public class LivroDetalhes {

	private String titulo;
	private String autor;
	private BigDecimal preco;
	private String sinopse;
	private String sumario;
	private int paginas;
	private String isbn;
	private LocalDate dataPublicacao;

	public LivroDetalhes(Livro livro) {
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor().getNome();
		this.preco = livro.getPreco();
		this.sinopse = livro.getSinopse();
		this.sumario = livro.getSumario();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getSinopse() {
		return sinopse;
	}

	public String getSumario() {
		return sumario;
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

}
