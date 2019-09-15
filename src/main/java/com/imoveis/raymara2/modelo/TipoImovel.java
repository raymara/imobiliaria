package com.imoveis.raymara2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class TipoImovel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank(message="{form.tipoimovel.descricao}")
	@Size(min=3, message="{form.tipoimovel.descricao.tamanho}")
	private String descricao;
	
	@NotNull(message="{form.tipoimovel.condominio}")
	private int condominio;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCondominio() {
		return condominio;
	}

	public void setCondominio(int condominio) {
		this.condominio = condominio;
	}
	
	
}
