package com.projetos.alugalivro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.alugalivro.model.Aluguel;
import com.projetos.alugalivro.model.Usuario;
import com.projetos.alugalivro.repositories.AluguelRepository;

@Service
public class AluguelService {
	private final AluguelRepository repository;
	
	@Autowired
	public AluguelService(AluguelRepository repository) {
		this.repository = repository;
	}
	
	public void cadastrar(Aluguel aluguel) {
		repository.save(aluguel);
	}
	
	public List<Aluguel> findByUsario(Usuario usuario){
		return repository.findAllByUsuario(usuario);
	}
}
