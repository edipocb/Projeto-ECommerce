package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemDoPedido;
import br.com.ecommerce.api.repository.ItemDoPedidoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    public ItemDoPedido buscarPorId(Integer id) {
        return itemDoPedidoRepository.findById(id).orElse(null);
    }
    public ItemDoPedido deletarItemDoPedido(Integer id) {
        ItemDoPedido itemDoPedido = buscarPorId(id);

        if (itemDoPedido == null) {
            return null;
        }
        itemDoPedidoRepository.delete(itemDoPedido);
        return itemDoPedido;
    }
}
