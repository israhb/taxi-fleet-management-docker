package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.RolDTO;
import com.mentedigital.israel.taxis.model.Rol;
import com.mentedigital.israel.taxis.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private IRolService repo;

    @GetMapping
    public ResponseEntity<List<RolDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<RolDTO> crear(@RequestBody Rol r){
        RolDTO fr = repo.crear(r);
        return ResponseEntity.created(URI.create("/api/rol"+fr.getId())).body(fr);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> actualizar(@PathVariable Long id, @RequestBody Rol r){
        return ResponseEntity.ok(repo.actualizar(id,r));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
