package com.projetos.alugalivro.controller;

import java.util.List;

import org.hibernate.annotations.DialectOverride.SQLRestriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.projetos.alugalivro.model.Genero;
import com.projetos.alugalivro.model.Livro;
import com.projetos.alugalivro.repositories.LivroRepository;
import com.projetos.alugalivro.services.AuthenticationService;
import com.projetos.alugalivro.services.LivroService;

@Controller
@RequestMapping("/home")

public class HomeController {	

    private final LivroService livroService;
    
    private final AuthenticationService authenticationService;
    
    @Autowired
    public HomeController(LivroService livroService, AuthenticationService authenticationService) {
        this.livroService = livroService;
        this.authenticationService = authenticationService;
    }
	
	@GetMapping
	
	public ModelAndView listar() {
		List<Livro> livros = livroService.findAll();;
		String logado = String.valueOf(authenticationService.isLogged());
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("livros", livros);
		mv.addObject("logado",logado);
		return mv;
	}
	
	@GetMapping("/{genero}")
	public ModelAndView listarPorGenero(@PathVariable("genero") String genero) {
		List<Livro> livros = livroService.findLivrosByGenero(Genero.valueOf(genero.toUpperCase()));
		String logado = String.valueOf(authenticationService.isLogged());
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("livros", livros);
		mv.addObject("genero", genero);
		mv.addObject("logado",logado);
		return mv;
	}
}
