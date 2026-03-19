package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.IngresoDTO;
import com.mentedigital.israel.taxis.model.Ingreso;
import com.mentedigital.israel.taxis.service.IIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ingreso")
public class IngresoController {

    @Autowired
    private IIngresoService repo;

    @GetMapping
    public ResponseEntity<List<IngresoDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<IngresoDTO> crear(@RequestBody Ingreso in){
        IngresoDTO i = repo.crear(in);
        return ResponseEntity.created(URI.create("/api/ingreso"+i.getId())).body(i);
    }
    @PutMapping("/{id}")
    public ResponseEntity<IngresoDTO> actualizar(@PathVariable Long id, @RequestBody Ingreso in){
        return ResponseEntity.ok(repo.actualziar(id, in));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
