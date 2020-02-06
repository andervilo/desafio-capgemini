package com.capgemini.banco.bancocapgeminibackend.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

public interface IRestController<DTO extends Serializable> {
		
    	public ResponseEntity<?> listAll();	
        public ResponseEntity<?> showById(Long id);	
        public ResponseEntity<?> create(DTO object, Errors errors);	
        public ResponseEntity<?> update(Long id, DTO object, Errors errors);	
        public ResponseEntity<?> delete(Long id);
    
    }