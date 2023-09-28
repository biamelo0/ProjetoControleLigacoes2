package com.projetoControleDeLigacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoControleDeLigacoes.entities.Ligacao;

public interface LigacaoRepository extends JpaRepository<Ligacao, Long>{

}
