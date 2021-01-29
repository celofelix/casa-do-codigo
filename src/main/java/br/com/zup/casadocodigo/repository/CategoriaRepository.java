package br.com.zup.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Optional<Categoria> findByNome(String nome);

}
