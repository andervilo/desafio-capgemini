package com.capgemini.banco.bancocapgeminibackend.model.entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Conta extends BaseEntity{

	private static final long serialVersionUID = -1030358348197180732L;

	private Long numero;
	
	private Agencia agencia;

	private Cliente cliente;

	private List<Movimentacao> movimentacoes;


	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Agencia getAgencia() {
		return this.agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacao> getMovimentacoes() {
		return this.movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}