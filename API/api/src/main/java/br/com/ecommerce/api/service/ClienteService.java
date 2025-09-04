package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Avisando o spring que isso e um servico
public class ClienteService {
    // Injecao de dependencia
    // Service depende de alguem (Depende do repository)

    private final ClienteRepository clienteRepository;
    // variavel final e que nunca muda(constante)

    public ClienteService(ClienteRepository repo){
        clienteRepository = repo;
    }  //metodo construtor que recebe um cliente
    // repository

    //Metodo todos os Listar para ver os clientes
    // usando list (Nao tem limite fixo) ideia e a mesma do vetor
    //Vetor tem limite
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

}
