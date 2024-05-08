package com.projetos.alugalivro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.projetos.alugalivro.dto.UsuarioDTO;
import com.projetos.alugalivro.model.Usuario;
import com.projetos.alugalivro.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView("cadastro");
		return mv;
	}
	
	@PostMapping("/novo")
	@Transactional
	public ModelAndView cadastro(@Valid UsuarioDTO usuario) {
		Usuario novoUsuario = new Usuario(usuario);
		novoUsuario.setSenha(encoder.encode(usuario.senha()));
		repository.save(novoUsuario);
		ModelAndView mv = new ModelAndView("redirect:/home");
		return mv;
	}
}
