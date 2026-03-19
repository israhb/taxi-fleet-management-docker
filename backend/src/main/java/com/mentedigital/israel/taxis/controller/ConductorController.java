package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.ConductorDTO;
import com.mentedigital.israel.taxis.model.Conductor;
import com.mentedigital.israel.taxis.service.IConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/conductor")
public class ConductorController {

    @Autowired
    private IConductorService repo;

    @GetMapping
    public ResponseEntity<List<ConductorDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<ConductorDTO> crear(@RequestBody Conductor c){
        ConductorDTO fc = repo.crear(c);
        return ResponseEntity.created(URI.create("/api/conductor"+fc.getId())).body(fc);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ConductorDTO> actualizar(@PathVariable Long id, @RequestBody Conductor c){
        return ResponseEntity.ok(repo.actualizar(id,c));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
