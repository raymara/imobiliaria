package com.imoveis.raymara2.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
public class Locacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull(message="{form.imovel.imovel}")
	@ManyToOne
	private Imovel imovel;
	
	@NotNull(message="{form.imovel.cliente}")
	@ManyToOne
	private Cliente cliente;
	
	@NotNull(message="{form.imovel.profissional}")
	@ManyToOne
	private Profissional profissional;
	

	
	//@Future(message="Data Inválida. Não é permitido uma data passada")
		@DateTimeFormat(pattern="dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		private Calendar datainicio;
		
		//@Future(message="Data Inválida. Não é permitido uma data passada")
		@DateTimeFormat(pattern="dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		private Calendar datafim;
		
		@NumberFormat(pattern = "#,##0.00")
		private BigDecimal valoraluguel;
		
		@NotBlank(message="{form.nome}")
		@Size(min=3, message="{form.nome.tamanho}")
		private String nome;
		
		private String observacao;

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

		public Imovel getImovel() {
			return imovel;
		}

		public void setImovel(Imovel imovel) {
			this.imovel = imovel;
		}

		public String getImovelNome() {
			Imovel imovel = getImovel();
			return imovel.getNome();
		}
		public Profissional getProfissional() {
			return profissional;
		}

		public void setProfissional(Profissional profissional) {
			this.profissional = profissional;
		}

		public BigDecimal getValoraluguel() {
			return valoraluguel;
		}


		public Calendar getDatainicio() {
			return datainicio;
		}

		public void setDatainicio(Calendar datainicio) {
			this.datainicio = datainicio;
		}

		public void setValoraluguel(BigDecimal valoraluguel) {
			this.valoraluguel = valoraluguel;
		}

		public Calendar getDatafim() {
			return datafim;
		}

		public void setDatafim(Calendar datafim) {
			this.datafim = datafim;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
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
