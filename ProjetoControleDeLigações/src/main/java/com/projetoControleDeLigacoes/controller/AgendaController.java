package com.projetoControleDeLigacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoControleDeLigacoes.entities.Agenda;
import com.projetoControleDeLigacoes.services.AgendaService;

@RestController
@RequestMapping("/agenda")

public class AgendaController {
    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> buscaProdutoControlId (@PathVariable Long id){
    	Agenda agenda = agendaService.buscaAgendaId(id);
    	if(agenda != null) {
    		return ResponseEntity.ok(agenda);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    	}
    @GetMapping("/")
    public ResponseEntity<List<Agenda>> buscaTodosAgendasControl(){
    	List<Agenda> agenda = agendaService.buscaTodosAgenda();
    	return ResponseEntity.ok(agenda);
    }
    @PostMapping("/")
    public ResponseEntity<Agenda> salvaAgendaControl(@RequestBody Agenda agenda){
    	Agenda salvaAgenda = agendaService.SalvaAgenda(agenda);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaAgenda);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Agenda> alteraProdutoControl(@PathVariable Long id, @RequestBody Agenda agenda){
    	Agenda alteraAgenda = agendaService.alterarProduto(id, agenda);
    	if (alteraAgenda != null) {
    		return ResponseEntity.ok(agenda);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id){
    	boolean apagar = agendaService.apagarAgenda(id);
    	if(apagar) {
    		return ResponseEntity.ok().body("O produto foi excluido com sucesso");
    	}
    	else {
    		return ResponseEntity.notFound().build();    	
    	}
    }
}


