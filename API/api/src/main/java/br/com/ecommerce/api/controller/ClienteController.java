package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Operações relacionadas ao cadastro de clientes")
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

      //Buscar cliente por id
      // GET
    @GetMapping("/{id}")
    // Path Variabe > recebe um valor no link ()
    // @RequestBody > recebe dados pelo corpo
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        // 1. Procurar o cliente
        Cliente cliente = clienteService.buscarPorId(id);
        //2. se nao encontrar, retorno um erro
        if (cliente == null) {
            // Mais simples:
            // return ResponseEntity.notFound().build()
            // Mais detalhes:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " nao encontrado!");
        }
        //3. Se encontrar, retorno o cliente
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarClientePorId(@PathVariable Integer id) {
        // 1. Verifico se o cliente existe
        Cliente cliente = clienteService.deletarCLiente(id);

        // 2. se nao existir, retorno nulo
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " nao encontrado!");

        }
        // 3. se existir, retorno ok
        return ResponseEntity.ok(cliente);
    }




}
