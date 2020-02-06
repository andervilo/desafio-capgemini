package com.capgemini.banco.bancocapgeminibackend.model.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IService<E extends Serializable, R extends JpaRepository<E, Long>> {
		
	public abstract List<E> findAll();
	
	public abstract Page<E> findAll(Pageable pageable);
	
	public abstract E findById(Long id);
	
	public abstract E create(E object);
	
	public abstract E update(Long id, E object);
	
	public abstract boolean delete(Long id);	
	
	public JpaRepository<E, Long> getRepository();

}