package com.projetos.alugalivro.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
		@NotBlank
		String nome, 
		
		@NotBlank
		String login, 
		
		@NotBlank
		String email,
		
		@NotBlank
		String senha,
		
		@NotBlank
		String cpf
		) {

}
