package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService service){
        produtoService =  service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produto = produtoService.listarTodos();
        return ResponseEntity.ok(produto);
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto produto
    ) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable Integer id) {

        Produto produto = produtoService.buscarPorId(id);

        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto "+ id + " nao encontrado");
        }
        return ResponseEntity.ok(produto);

    }
}
