package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.ConductorDTO;
import com.mentedigital.israel.taxis.dto.GastoDTO;
import com.mentedigital.israel.taxis.model.Conductor;
import com.mentedigital.israel.taxis.model.Gasto;
import com.mentedigital.israel.taxis.service.IGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/gasto")
public class GastoController {

    @Autowired
    private IGastoService repo;

    @GetMapping
    public ResponseEntity<List<GastoDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<GastoDTO> crear(@RequestBody Gasto g){
        GastoDTO fc = repo.crear(g);
        return ResponseEntity.created(URI.create("/api/gasto"+fc.getId())).body(fc);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GastoDTO> actualizar(@PathVariable Long id, @RequestBody Gasto g){
        return ResponseEntity.ok(repo.actualizar(id, g));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
