package com.projetoControleDeLigacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoControleDeLigacoes.entities.Ligacao;
import com.projetoControleDeLigacoes.repository.LigacaoRepository;

@Service
public class LigacaoService {
    private final LigacaoRepository ligacaoRepository;

    @Autowired
    public LigacaoService(LigacaoRepository ligacaoRepository) {
        this.ligacaoRepository = ligacaoRepository;
    }

    public Ligacao saveligacaoligacao(Ligacao ligacao) {
        return ligacaoRepository.save(ligacao);
    }

    public Ligacao getLigacaoById(Long id) {
        return ligacaoRepository.findById(id).orElse(null);
    }

    public List<Ligacao> buscaTodosLigacao() {
        return ligacaoRepository.findAll();
    }
    
    public Ligacao buscaLigacaoId(Long id) {
       Optional <Ligacao> ligacao = ligacaoRepository.findById(id);
       return ligacao.orElse(null);
    }
    public Ligacao SalvaLigacao(Ligacao ligacao) {
    	return ligacaoRepository.save(ligacao);
    }
    public Ligacao alterarProduto (Long id, Ligacao alterarLigacao) {
    	Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
    	if (existeLigacao.isPresent()) {
    		alterarLigacao.setId(id);
    		return ligacaoRepository.save(alterarLigacao);
    	}
    	return null;
    }
    public boolean apagarLigacao(Long id) {
    	Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
    	if (existeLigacao.isPresent()) {
    		ligacaoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}