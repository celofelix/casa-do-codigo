package br.com.zup.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.modelo.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	Optional<Pais> findByNome(String nome);
	}
