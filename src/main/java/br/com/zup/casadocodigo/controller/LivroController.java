package br.com.zup.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.modelo.Livro;
import br.com.zup.casadocodigo.modelo.dto.LivroDetalhes;
import br.com.zup.casadocodigo.modelo.dto.LivroDto;
import br.com.zup.casadocodigo.modelo.form.LivroForm;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import br.com.zup.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	AutorRepository autorRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<LivroDto>> listar(@RequestParam(required = false) Long id) {
		List<Livro> livros = livroRepository.findAll();
		return ResponseEntity.ok().body(LivroDto.converter(livros));
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroDetalhes> listarDetalhes(@PathVariable(value = "id") Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok().body(new LivroDetalhes(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid LivroForm livro) {
		Livro novoLivro = livro.converter(autorRepository, categoriaRepository);
		livroRepository.save(novoLivro);
		return ResponseEntity.ok().build();
	}
}
