package br.com.zup.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	Optional<Estado> findByNome(String nome);

}
