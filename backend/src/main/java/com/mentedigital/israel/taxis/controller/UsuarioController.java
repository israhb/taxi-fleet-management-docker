package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.UsuarioDTO;
import com.mentedigital.israel.taxis.model.Usuario;
import com.mentedigital.israel.taxis.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService repo;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody Usuario u){
        UsuarioDTO fu = repo.crear(u);
        return ResponseEntity.created(URI.create("/api/usuario"+fu.getId())).body(fu);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Long id, @RequestBody Usuario u){
        return ResponseEntity.ok(repo.actualizar(id, u));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.elimnar(id);
        return ResponseEntity.noContent().build();
    }
}
