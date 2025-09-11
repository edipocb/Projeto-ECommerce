package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.repository.ItemDoPedidoRepository;
import br.com.ecommerce.api.service.ItemDoPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/itemdopedido")
public class ItemDoPedidoController {

    private ItemDoPedidoService itemDoPedidoService;

    public ItemDoPedidoController(ItemDoPedidoService service) {
        itemDoPedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemDoPedido>> listarTodos() {
        List<ItemDoPedido> itemDoPedido = itemDoPedidoService.listarTodos();

        return ResponseEntity.ok(itemDoPedido);
    }

    @PostMapping("/cadastrarItem")
    public ResponseEntity<ItemDoPedido> cadastrarItem(
            @RequestBody ItemDoPedido itemDoPedido
    ) {
        itemDoPedidoService.cadastrarItemDoPedido(itemDoPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemDoPedido);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarItemPorId(@PathVariable Integer id) {
        ItemDoPedido itemDoPedido = itemDoPedidoService.buscarPorId(id);

        if (itemDoPedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido " + id + " nao encontrado");
        }
        return ResponseEntity.ok(itemDoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarItemPorId(@PathVariable Integer id) {
        ItemDoPedido itemDoPedido = itemDoPedidoService.deletarItemDoPedido(id);

        if (itemDoPedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido " + id + " nao encontrado");
        }

        return ResponseEntity.ok(itemDoPedido);
    }

}

