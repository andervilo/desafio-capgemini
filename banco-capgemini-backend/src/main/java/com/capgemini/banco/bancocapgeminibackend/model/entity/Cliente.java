package com.capgemini.banco.bancocapgeminibackend.model.entity;

import javax.persistence.Entity;

import com.capgemini.banco.bancocapgeminibackend.model.dto.ClienteDTO;

@Entity
public class Cliente extends BaseEntity<Cliente, ClienteDTO>{

	private static final long serialVersionUID = -3800460870409603351L;

	private String nome;
	
	private String cpf;

	private String celular;

	private String email;

	private Conta conta;


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			", cpf='" + getCpf() + "'" +
			", celular='" + getCelular() + "'" +
			", email='" + getEmail() + "'" +
			", conta='" + getConta() + "'" +
			"}";
	}

	@Override
	public ClienteDTO toDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente fromDTO(ClienteDTO object) {
		// TODO Auto-generated method stub
		return null;
	}

}