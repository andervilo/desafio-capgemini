package com.capgemini.banco.bancocapgeminibackend.model.repository;

import com.capgemini.banco.bancocapgeminibackend.model.entity.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}