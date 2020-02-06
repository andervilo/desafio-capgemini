package com.capgemini.banco.bancocapgeminibackend.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<T extends Serializable, DTO extends Serializable> implements Serializable{

	private static final long serialVersionUID = 8924889531041197455L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	protected Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public abstract DTO toDTO();

	public abstract T fromDTO(DTO object);

}