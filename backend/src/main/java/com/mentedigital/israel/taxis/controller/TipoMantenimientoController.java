package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.TipoMantenimientoDTO;
import com.mentedigital.israel.taxis.model.TipoMantenimiento;
import com.mentedigital.israel.taxis.service.ITipoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipoMantenimiento")
public class TipoMantenimientoController {

    @Autowired
    private ITipoMantenimientoService repo;

    @GetMapping
    public ResponseEntity<List<TipoMantenimientoDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<TipoMantenimientoDTO> crear(@RequestBody TipoMantenimiento m){
        TipoMantenimientoDTO ft = repo.crear(m);
        return ResponseEntity.created(URI.create("/api/tipoMantenimiento"+ft.getId())).body(ft);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoMantenimientoDTO> actualizar(@PathVariable Long id, @RequestBody TipoMantenimiento m){
        return ResponseEntity.ok(repo.actualizar(id, m));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
