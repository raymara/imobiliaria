package com.imoveis.raymara2.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull(message="{form.imovel.cliente}")
	@ManyToOne
	private Cliente cliente;
	
	@NotNull(message="{form.imovel.tipoimovel}")
	@ManyToOne
	private TipoImovel tipoimovel;
	
	@NotBlank(message="{form.nome}")
	@Size(min=3, message="{form.nome.tamanho}")
	private String nome;
	
	@NotBlank(message="{form.endereco}")
	@Size(min=3, message="{form.endereco.tamanho}")
	private String endereco;
	
	private String bairro;
	private String cep;
	private String referencia;
	private double metragem;
	private int dormitorio;
	private int banheiro;
	private int suite;
	private int vaga_garagem;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valoraluguel;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valoriptu;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getClienteNome() {
		Cliente cliente = getCliente();
		return cliente.getNome();
	}

	public TipoImovel getTipoimovel() {
		return tipoimovel;
	}


	public void setTipoimovel(TipoImovel tipoimovel) {
		this.tipoimovel = tipoimovel;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public double getMetragem() {
		return metragem;
	}


	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}


	public int getDormitorio() {
		return dormitorio;
	}


	public void setDormitorio(int dormitorio) {
		this.dormitorio = dormitorio;
	}


	public int getBanheiro() {
		return banheiro;
	}


	public void setBanheiro(int banheiro) {
		this.banheiro = banheiro;
	}


	public int getSuite() {
		return suite;
	}


	public void setSuite(int suite) {
		this.suite = suite;
	}


	public int getVaga_garagem() {
		return vaga_garagem;
	}

	public void setVaga_garagem(int vaga_garagem) {
		this.vaga_garagem = vaga_garagem;
	}

	public BigDecimal getValoraluguel() {
		return valoraluguel;
	}


	public void setValoraluguel(BigDecimal valoraluguel) {
		this.valoraluguel = valoraluguel;
	}


	public BigDecimal getValoriptu() {
		return valoriptu;
	}


	public void setValoriptu(BigDecimal valoriptu) {
		this.valoriptu = valoriptu;
	}


	public boolean ehNovo() {
		return (this.codigo == null);
	}
}
