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

    @GetMapping
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

}
