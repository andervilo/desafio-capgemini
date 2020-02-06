package com.capgemini.banco.bancocapgeminibackend.model.entity;

import javax.persistence.Entity;

import com.capgemini.banco.bancocapgeminibackend.model.dto.AgenciaDTO;

@Entity
public class Agencia extends BaseEntity<Agencia, AgenciaDTO>{

	private static final long serialVersionUID = -8748571862745479370L;

	private Long numero;
	
	private String nome;


	public Agencia() {
	}

	public Agencia(Long numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "{" +
			" numero='" + getNumero() + "'" +
			", nome='" + getNome() + "'" +
			"}";
	}

	@Override
	public AgenciaDTO toDTO() {		
		return new AgenciaDTO(this.getNumero(), this.getNome());
	}

	@Override
	public Agencia fromDTO(AgenciaDTO object) {
		return new Agencia(object.getNumero(), object.getNome());
	}


}