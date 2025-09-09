package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.repository.ItemDoPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDoPedidoService {

    private final ItemDoPedidoRepository itemDoPedidoRepository;

    public ItemDoPedidoService(ItemDoPedidoRepository repo) {
        itemDoPedidoRepository = repo;
    }

    public List<ItemDoPedido> listarTodos(){
        return itemDoPedidoRepository.findAll();
    }

    public ItemDoPedido cadastrarItemDoPedido(ItemDoPedido itemDoPedido){
        return itemDoPedidoRepository.save(itemDoPedido);
    }
}
