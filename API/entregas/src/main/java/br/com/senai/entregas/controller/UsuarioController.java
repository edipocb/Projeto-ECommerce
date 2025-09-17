package br.com.senai.entregas.controller;


import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService service) {
        usuarioService = service;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuario = usuarioService.listarTodos();
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/api/cadastrarUsuario")
    public ResponseEntity<Usuario> cadastrarUsuario(
            @RequestBody Usuario usuario
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }



}
