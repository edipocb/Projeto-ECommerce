package br.com.senai.entregas.controller;


import br.com.senai.entregas.model.Veiculo;
import br.com.senai.entregas.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    private VeiculoService veiculoService;
    public VeiculoController(VeiculoService service) {
        veiculoService = service;
    }


    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculo = veiculoService.listarVeiculos();
        return ResponseEntity.ok().body(veiculo);
    }

    
    @PostMapping("/api/cadastrarVeiculo")
    public ResponseEntity<Veiculo> cadastrarVeiculo(
            @RequestBody Veiculo veiculo) {
        veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }




}
