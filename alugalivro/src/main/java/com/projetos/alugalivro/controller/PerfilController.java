package com.projetos.alugalivro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projetos.alugalivro.dto.UsuarioPutDTO;
import com.projetos.alugalivro.model.Aluguel;
import com.projetos.alugalivro.model.Usuario;
import com.projetos.alugalivro.services.AluguelService;
import com.projetos.alugalivro.services.AuthenticationService;
import com.projetos.alugalivro.services.UsuarioService;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	private final UsuarioService usuarioService;
	private final AluguelService aluguelService;
	
	private final AuthenticationService authenticationService;
	

	@Autowired
	public PerfilController(UsuarioService usuarioService, AuthenticationService authService, AluguelService aluguelService) {
		this.usuarioService = usuarioService;
		this.authenticationService = authService;
		this.aluguelService= aluguelService;
	}
	
	@GetMapping
	public ModelAndView getPerfil() {
		String email = authenticationService.getLoggedUserName();
		Usuario usuario = usuarioService.findByEmail(email);
		
		List<Aluguel> alugueis = aluguelService.findByUsario(usuario);
		ModelAndView mv = new ModelAndView("/perfil");
		mv.addObject("usuario", usuario);
		
		mv.addObject("alugueis", alugueis);
		return mv;
	}	
	
	
	@PutMapping("/editar")
	@Transactional
	public ModelAndView putPerfil( UsuarioPutDTO dados){
		usuarioService.update(authenticationService.getLoggedUserName(), dados);

		ModelAndView mv = new ModelAndView("redirect:/home");
		return mv;
		
	}
}
