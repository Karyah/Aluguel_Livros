package com.projetos.alugalivro.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.projetos.alugalivro.dto.AluguelDTO;
import com.projetos.alugalivro.model.Aluguel;
import com.projetos.alugalivro.model.Livro;
import com.projetos.alugalivro.model.Usuario;
import com.projetos.alugalivro.services.AluguelService;
import com.projetos.alugalivro.services.AuthenticationService;
import com.projetos.alugalivro.services.LivroService;
import com.projetos.alugalivro.services.UsuarioService;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/livro")
public class LivroController {
	
	private final LivroService livroService;
	private final AluguelService aluguelService;
	private final AuthenticationService authService;
	private final UsuarioService usuarioService;
	
	@Autowired
	public LivroController(LivroService livroService, AluguelService aluguelService, AuthenticationService authService, UsuarioService usuarioService) {
		this.livroService = livroService;
		this.aluguelService = aluguelService;
		this.authService= authService;
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getLivro(@PathVariable("id") String id) {
		Livro livro = livroService.findById(id);	
		ModelAndView mv = new ModelAndView("/livro");
		mv.addObject(livro);
		return mv;
	}
	
	@PostMapping("/{id}")
	@Transactional
	public ModelAndView alugar(@PathVariable("id") String id ) {
		Usuario usuario = usuarioService.findByEmail(authService.getLoggedUserName());
		Livro livro = livroService.findById(id);
		
		livro.desativar();
		
		Aluguel aluguel = new Aluguel(usuario, livro);
		
		LocalDate dataAtual = LocalDate.now();	
		LocalDate dataDevolucao = LocalDate.now().plusMonths(1);

		aluguel.setDataAquisicao(Date.valueOf(dataAtual));
		aluguel.setDataDevolucao( Date.valueOf(dataDevolucao));
		
		aluguelService.cadastrar(aluguel);
		ModelAndView mv = new ModelAndView("redirect:/perfil");
		return mv;
		
	}
}
