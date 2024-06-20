package com.projetos.alugalivro.model;

import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLivro")
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String autor;
	
	@Column(nullable = false)
	private String urlImagem;
	
	@Column(nullable = false)
	private String sinopse;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Column(nullable = false)
	private boolean disponivel;

	public void desativar() {
		this.disponivel= false;
		
	}
	
}
