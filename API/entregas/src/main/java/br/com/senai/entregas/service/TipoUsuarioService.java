package br.com.senai.entregas.service;


import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;
    //Construtor
    public TipoUsuarioService(TipoUsuarioRepository repo) {
        tipoUsuarioRepository = repo;
    }

    public List<TipoUsuario> listarTodos(){
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuario cadastrarTipoUser(TipoUsuario tipoUsuario){
        return tipoUsuarioRepository.save(tipoUsuario);
    }



}
