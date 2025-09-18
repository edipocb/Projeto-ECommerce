package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService service){
        enderecoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos(){
        List<Endereco> endereco = enderecoService.listarTodos();
        return ResponseEntity.ok().body(endereco);
    }

    @PostMapping("/api/cadastrarEndereco")
    public  ResponseEntity<Endereco> cadastrarEndereco(
            @RequestBody Endereco endereco){
        enderecoService.cadastroEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }


}
