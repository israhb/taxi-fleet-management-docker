package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.AsignacionTaxiConductorDTO;
import com.mentedigital.israel.taxis.model.AsignacionTaxiConductor;
import com.mentedigital.israel.taxis.service.IAsignacionTaxiConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/asignacionTaxiConductor")
public class AsignacionTaxiConductorController {

    @Autowired
    private IAsignacionTaxiConductorService repo;

    @GetMapping
    public ResponseEntity<List<AsignacionTaxiConductorDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<AsignacionTaxiConductorDTO> crear(@RequestBody AsignacionTaxiConductor as){
        AsignacionTaxiConductorDTO a = repo.crear(as);
        return ResponseEntity.created(URI.create("/api/asignacionTaxiConductor"+a.getId())).body(a);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AsignacionTaxiConductorDTO> actualizar(@PathVariable Long id, @RequestBody AsignacionTaxiConductor as){
        return ResponseEntity.ok(repo.actualizar(id, as));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
