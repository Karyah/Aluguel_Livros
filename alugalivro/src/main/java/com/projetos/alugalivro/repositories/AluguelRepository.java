package com.projetos.alugalivro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.alugalivro.model.Aluguel;
import com.projetos.alugalivro.model.Usuario;

public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
	List<Aluguel> findAllByUsuario(Usuario usuario);
}
 