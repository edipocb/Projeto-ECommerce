package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.ClienteRepository;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository repo) {
        pagamentoRepository = repo;
    }

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento cadastrarPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPorId(Integer id){
        return pagamentoRepository.findById(id).orElse(null);
    }


    public Pagamento deletarPagamento(Integer id){
        Pagamento pagamento = buscarPorId(id);

        if (pagamento == null) {
            return null;
        }
        pagamentoRepository.delete(pagamento);
        return pagamento;
    }

}
