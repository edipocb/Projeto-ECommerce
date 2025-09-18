package br.com.senai.entregas.controller;


import br.com.senai.entregas.model.Entrega;
import br.com.senai.entregas.service.EntregaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrega")
public class EntregaController {

    private EntregaService entregaService;

    public EntregaController(EntregaService service) {
        entregaService = service;
    }

    @GetMapping
    public ResponseEntity<List<Entrega>> listarEntregas(){
        List<Entrega> entrega = entregaService.listarTodos();
        return ResponseEntity.ok().body(entrega);
    }

    @PostMapping("/api/cadastrarEntrega")
    public ResponseEntity<Entrega>  cadastrarEntrega(
            @RequestBody Entrega entrega){

        entregaService.cadastrarEntrega(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
    }




}
