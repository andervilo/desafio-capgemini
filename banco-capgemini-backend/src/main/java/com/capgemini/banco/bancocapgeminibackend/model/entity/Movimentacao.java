package com.capgemini.banco.bancocapgeminibackend.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

import com.capgemini.banco.bancocapgeminibackend.enumeration.TipoMovimentacaoEnum;

@Entity
public class Movimentacao extends BaseEntity{

	private static final long serialVersionUID = 6262299118485160305L;

	private TipoMovimentacaoEnum tipoMovimentacao;
	
	private Conta conta;

	private BigDecimal valor;

	private Date dataMovimentacao;

	public Movimentacao() {
	}

	public Movimentacao(TipoMovimentacaoEnum tipoMovimentacao, Conta conta, BigDecimal valor, Date dataMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
		this.conta = conta;
		this.valor = valor;
		this.dataMovimentacao = dataMovimentacao;
	}

	public TipoMovimentacaoEnum getTipoMovimentacao() {
		return this.tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacaoEnum tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataMovimentacao() {
		return this.dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	@Override
	public String toString() {
		return "{" +
			" tipoMovimentacao='" + getTipoMovimentacao().getDescricao() + "'" +
			", conta='" + getConta() + "'" +
			", valor='" + getValor() + "'" +
			", dataMovimentacao='" + getDataMovimentacao() + "'" +
			"}";
	}
	
}