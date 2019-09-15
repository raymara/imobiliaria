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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	
	@NotNull(message="{form.imovel.imovel}")
	@ManyToOne
	private Imovel imovel;
	
	@NotNull(message="{form.imovel.profissional}")
	@ManyToOne
	private Profissional profissional;
	
	//@Future(message="Data Inválida. Não é permitido uma data passada")
		@DateTimeFormat(pattern="dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		private Calendar data;
		
		@NotNull(message = "{form.profissional.valorhora}")
		@NumberFormat(pattern = "#,##0.00")
		private BigDecimal valor;
		
		private String observacao;
		
		

	public Integer getCodigo() {
			return codigo;
		}



		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
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

		public String getProfissionallNome() {
			Profissional profissional = getProfissional();
			return profissional.getNome();
		}

		public void setProfissional(Profissional profissional) {
			this.profissional = profissional;
		}



		public Calendar getData() {
			return data;
		}



		public void setData(Calendar data) {
			this.data = data;
		}


		public BigDecimal getValor() {
			return valor;
		}



		public void setValor(BigDecimal valor) {
			this.valor = valor;
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
