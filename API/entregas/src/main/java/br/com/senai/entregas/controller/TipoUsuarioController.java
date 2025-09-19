package br.com.senai.entregas.controller;


import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.service.TipoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipousuario")
public class TipoUsuarioController {


    private TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService service) {
        tipoUsuarioService = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TipoUsuario>> listarTipoUsuario() {
        List<TipoUsuario> tipoUsuario = tipoUsuarioService.listarTodos();
        return ResponseEntity.ok().body(tipoUsuario);
    }

   @PostMapping("/api/cadastrarTipoUser")
    public ResponseEntity<TipoUsuario> cadastrarTipoUser(
            @RequestBody TipoUsuario tipoUsuario){
        tipoUsuarioService.cadastrarTipoUser(tipoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuario);
   }

   @GetMapping("/buscar{id}")
    public ResponseEntity<?> buscarTipoUsuarioPorId(
            @PathVariable Integer id){
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarPorId(id);

        if (tipoUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de " +
                    "usuario nao encontrado");
        }
        return ResponseEntity.ok(tipoUsuario);
   }

   @DeleteMapping("/deletar{id}")
    public ResponseEntity<?> deletarTipoUsuarioPorId(
            @PathVariable Integer id){
        TipoUsuario tipoUsuario = tipoUsuarioService.deletarTipoUser(id);

        if (tipoUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de usuario nao encontrado");
        }
                return ResponseEntity.ok(tipoUsuario);
            }

   }

