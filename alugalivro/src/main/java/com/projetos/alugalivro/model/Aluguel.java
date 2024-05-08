package com.projetos.alugalivro.model;

import java.util.Date;
import com.projetos.alugalivro.dto.AluguelDTO;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="aluguel")
public class Aluguel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dataDevolucao;
	
	private Date dataAquisicao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_livro", nullable = false)
	private Livro livro;

	public Aluguel(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
	}
	
	
}
