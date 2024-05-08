package com.projetos.alugalivro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.alugalivro.dto.UsuarioPutDTO;
import com.projetos.alugalivro.model.Usuario;
import com.projetos.alugalivro.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario findByEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
	
	public void update(String email, UsuarioPutDTO dados) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if (dados.cpf() != null) {
			usuario.setCpf(dados.cpf());
		}
		if (dados.email() != null) {
			usuario.setEmail(dados.email());
		}
		if (dados.nome() != null) {
			usuario.setNome(dados.nome());
		}
		
		usuarioRepository.save(usuario);
		
	}
}
