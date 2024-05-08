package com.projetos.alugalivro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetos.alugalivro.model.Genero;
import com.projetos.alugalivro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	List<Livro> findByGeneroAndDisponivelTrue(Genero genero);
	List<Livro> findAllByDisponivelTrue();
}
