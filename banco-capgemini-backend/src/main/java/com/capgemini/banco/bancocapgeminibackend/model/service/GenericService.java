package com.capgemini.banco.bancocapgeminibackend.model.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<E extends Serializable, R extends JpaRepository<E, Long>> implements IService<E,R>{
    @Autowired
	private R repository;

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public E findById(Long id) {
		Optional<E> model = repository.findById(id);
		if(model.isPresent()) return model.get();
		return null;
	}

	@Override
	public E create(E object) {
		return repository.saveAndFlush(object);
	}

	@Override
	public E update(Long id, E object) {
		if(repository.existsById(id)) {
			return repository.saveAndFlush(object);			
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		Optional<E> model = repository.findById(id);
		if(model.isPresent()) {
			repository.delete(model.get());	
			return true;			
		}
		return false;
	}

	@Override
	public JpaRepository<E, Long> getRepository() {
		return this.repository;
	}
}