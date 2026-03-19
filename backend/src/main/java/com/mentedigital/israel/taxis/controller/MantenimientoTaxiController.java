package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.MantenimientoTaxiDTO;
import com.mentedigital.israel.taxis.model.MantenimientoTaxi;
import com.mentedigital.israel.taxis.service.IMantenimientoTaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/mantenimientoTaxi")
public class MantenimientoTaxiController {

    @Autowired
    private IMantenimientoTaxiService repo;

    @GetMapping
    public ResponseEntity<List<MantenimientoTaxiDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<MantenimientoTaxiDTO> crear(@RequestBody MantenimientoTaxi m){
        MantenimientoTaxiDTO fm = repo.crear(m);
        return ResponseEntity.created(URI.create("/api/mantenimientoTaxi"+fm.getId())).body(fm);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoTaxiDTO> actualizar(@PathVariable Long id, @RequestBody MantenimientoTaxi m){
        return ResponseEntity.ok(repo.actualziar(id,m));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
