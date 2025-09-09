package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    // Controller depende do service

    //Injecao de dependencia
    private ClienteService clienteService;

    //Pedindo para o spring retornar o servico
    public ClienteController(ClienteService service) {
        clienteService = service;
    }

    // Listar todos
    // @GetMapping um metodo que te da acesso a uma porta
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        // 1. Pegar lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrarCliente(
            // @RequestBody para informar de onde vem o cliente
            @RequestBody Cliente cliente
    ) {
        // 1- Tentar cadastrar um cliente
        clienteService.cadastrarCliente(cliente);
        // Codigo 200 - OK
        //return ResponseEntity.ok(cliente);
        // Codigo 201 - create
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
      }
}
