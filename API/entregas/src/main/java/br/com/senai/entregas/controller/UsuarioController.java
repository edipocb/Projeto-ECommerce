package br.com.senai.entregas.controller;


import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.TipoUsuarioService;
import br.com.senai.entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final TipoUsuarioService tipoUsuarioService;
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService service, TipoUsuarioService tipoUsuarioService) {
        usuarioService = service;
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuario = usuarioService.listarTodos();
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/api/cadastrarUsuario")
    public ResponseEntity<Usuario> cadastrarUsuario(
            @RequestBody Usuario usuario) {

        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/buscarPorId{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Integer id){
        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado");
        }
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/deletarUsuario{id}")
    public ResponseEntity<?> deletarUsuario(
            @PathVariable Integer id){
        Usuario usuario = usuarioService.deletarUsuario(id);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado");
        }
        return ResponseEntity.ok(usuario);
        }
    }

