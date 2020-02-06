package com.capgemini.banco.bancocapgeminibackend.model.dto;

import java.io.Serializable;

public class AgenciaDTO implements Serializable{

    private static final long serialVersionUID = -8639262617039205704L;
    
    private Long id;

    private Long numero;
	
	private String nome;


	public AgenciaDTO() {
	}

	public AgenciaDTO(Long numero, String nome) {
		this.numero = numero;
		this.nome = nome;
    }

    public AgenciaDTO(Long id, Long numero, String nome) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
}