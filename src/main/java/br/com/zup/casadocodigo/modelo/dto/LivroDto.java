package br.com.zup.casadocodigo.modelo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.casadocodigo.modelo.Livro;

public class LivroDto {
	
	private Long id;
	private String titulo;
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();		
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public static List<LivroDto> converter(List<Livro> livro){
		return livro.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
