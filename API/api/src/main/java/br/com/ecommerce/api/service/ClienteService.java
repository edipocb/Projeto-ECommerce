package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Produto;
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

    public Cliente cadastrarCliente(Cliente cl) {
        return clienteRepository.save(cl);
    }

    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente deletarCliente(Integer id) {
        //1. Verifico se  cliene existe
        Cliente cliente = buscarPorId(id);

        //2. Se nao existir, retorno nullo
        if (cliente == null) {
            return null;
        }
        //3. Se existir, excluo
        clienteRepository.delete(cliente);
        return cliente;
    }

    // Atualizar/Editar

    public Cliente atualizarCliente(Integer id, Cliente clienteNovo) {
    // 1. Procurar quem eu quero atualizar
        Cliente clienteAntigo = buscarPorId(id);


    // 2. Se eu nao achar, retorno nulo
        if (clienteAntigo == null) {
            return null;
        }

    // 3. Se eu achar eu atualizo
    clienteAntigo.setSenha(clienteNovo.getSenha());
    clienteAntigo.setNomeCompleto(clienteNovo.getNomeCompleto());
    clienteAntigo.setEmail(clienteNovo.getEmail());
    clienteAntigo.setDataCadastro(clienteNovo.getDataCadastro());
    return clienteRepository.save(clienteAntigo);
    }


}
