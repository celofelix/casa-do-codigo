package br.com.zup.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	Optional<Livro> findByTitulo(String titulo);
	Optional<Livro> findByIsbn(String titulo);
}
