package com.capgemini.banco.bancocapgeminibackend.model.repository;

import com.capgemini.banco.bancocapgeminibackend.model.entity.Movimentacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{

    
}