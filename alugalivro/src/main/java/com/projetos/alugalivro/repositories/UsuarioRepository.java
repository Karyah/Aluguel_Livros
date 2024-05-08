package com.projetos.alugalivro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.alugalivro.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
