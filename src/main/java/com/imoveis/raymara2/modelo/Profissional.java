package com.imoveis.raymara2.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Profissional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank(message="{form.nome}")
	@Size(min=3, message="{form.nome.tamanho}")
	private String nome;
	
	@NotBlank(message="{form.profissional.profissao}")
	@Size(min=3, message="{form.profissional.profissao.tamanho}")
	private String profissao;
	
	@NotBlank(message="{form.telefone}")
	@Size(min=8, message="{form.telefone.tamanho}")
	private String telefone;
	
	private String celular;
	
	@NotNull(message = "{form.profissional.valorhora}")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorhora;
	
	private String observacao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public BigDecimal getValorhora() {
		return valorhora;
	}

	public void setValorhora(BigDecimal valorhora) {
		this.valorhora = valorhora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public boolean ehNovo() {
		return (this.codigo == null);
	}
}
