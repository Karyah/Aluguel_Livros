package com.projetos.alugalivro.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetos.alugalivro.model.Genero;
import com.projetos.alugalivro.model.Livro;
import com.projetos.alugalivro.repositories.LivroRepository;

@Service
public class LivroService {
	
	 private final LivroRepository livroRepository;

	    @Autowired
	    public LivroService(LivroRepository livroRepository) {
	        this.livroRepository = livroRepository;
	    }
	    	
	   
	    public List<Livro> findLivrosByGenero(Genero genero) {
	        return livroRepository.findByGeneroAndDisponivelTrue(genero);
	    }
	    
	    public List<Livro> findAll(){
	    	return livroRepository.findAllByDisponivelTrue();
	    }
	    
	    public Livro findById(String id){
	    	Long longId = Long.valueOf(id); 
	    	Optional<Livro> livro = livroRepository.findById(longId);
	    	return livro.orElseThrow();
	    }
	}
	

