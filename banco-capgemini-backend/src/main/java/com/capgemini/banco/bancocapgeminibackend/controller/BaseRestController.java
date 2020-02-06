package com.capgemini.banco.bancocapgeminibackend.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.capgemini.banco.bancocapgeminibackend.Utils.UtilsValidator;
import com.capgemini.banco.bancocapgeminibackend.model.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * BaseRestController
 */
public abstract class BaseRestController<E extends Serializable, DTO extends Serializable, R extends JpaRepository<E, Long>, S extends IService<E, R>>  implements IRestController<DTO>{
	@Autowired
	private S service;
    
    @SuppressWarnings("unchecked")
	@GetMapping("")
	@Override
	public ResponseEntity<?> listAll() {
		List<E> list = service.findAll();
		return ResponseEntity.ok().body(list);
    }
    
    @SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	@Override
	public ResponseEntity<?> showById(@PathVariable Long id) {
		E entity = (E) service.findById(id);
		if(entity==null) {
			String nullResponse = "{\"message\":\"Recurso não encontrado!\", \"statusCode\":"+HttpStatus.NOT_FOUND.value()+"}";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nullResponse);
		}
		return (ResponseEntity<?>) ResponseEntity.ok().body(entity);
    }
    
    @SuppressWarnings("unchecked")
	@PostMapping(value="", consumes = "application/json")
	@Override
	public ResponseEntity<?> create(@Valid @RequestBody DTO object , Errors errors) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();

        if (errors.hasErrors()) {	
            return ResponseEntity.badRequest().body(UtilsValidator.formatarErros(errors));
        }
		
		if(object == null) {
			map.put("success", false);
			map.put("message", "Requisição feita com objeto nulo!");
			return ResponseEntity.badRequest().body(map);
		}
		
		E entity = (E) service.create(object);
		
		if(entity == null) {
			map.put("success", false);
			map.put("message", "Não foi possível executar esta operação!");
			return ResponseEntity.badRequest().body(map);
		}
		
		map.put("success", true);
		map.put("data", entity);
		map.put("message", "Operação realizada com sucesso!");
		
		return ResponseEntity.ok().body(map);
    }
    
    @SuppressWarnings("unchecked")
	@PutMapping(value="/{id}", consumes = "application/json")
	@Override
	public ResponseEntity<?> update(Long id, @Valid DTO object, Errors errors) {
		Map<Object, Object> map = new HashMap<Object, Object>();

        if (errors.hasErrors()) {	
            return ResponseEntity.badRequest().body(UtilsValidator.formatarErros(errors));
        }
		
		if(object == null) {
			map.put("success", false);
			map.put("message", "Requisição feita com objeto nulo!");
			return ResponseEntity.badRequest().body(map);
		}
				
		E entity = (E) service.update(id, object);
		
		if(entity == null) {
			map.put("success", false);
			map.put("message", "Não foi possível executar esta operação!");
			return ResponseEntity.badRequest().body(map);
		}
		
		map.put("success", true);
		map.put("data", entity);
		map.put("message", "Operação realizada com sucesso!");
		
		return ResponseEntity.ok().body(map);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Map<Object, Object>> delete(@PathVariable Long id) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(service.delete(id)) {
			map.put("success", true);
			map.put("message", "Operação realizada com sucesso!");
			return ResponseEntity.ok().body(map);
		}
		
		map.put("success", false);
		return ResponseEntity.ok().body(map);
	}

	public S getService() {
		return service;
	}
}