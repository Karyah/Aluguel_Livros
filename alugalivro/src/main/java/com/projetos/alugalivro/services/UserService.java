package com.projetos.alugalivro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.projetos.alugalivro.repositories.UsuarioRepository;


@Component
public class UserService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var nome = repository.findByEmail(username);
		return nome;
	}

}
