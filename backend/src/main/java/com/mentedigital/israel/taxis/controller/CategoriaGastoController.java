package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.CategoriaGastoDTO;
import com.mentedigital.israel.taxis.model.CategoriaGasto;
import com.mentedigital.israel.taxis.service.ICategoriaGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categoriaGasto")
public class CategoriaGastoController {

    @Autowired
    private ICategoriaGastoService repo;

    @GetMapping
    public ResponseEntity<List<CategoriaGastoDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<CategoriaGastoDTO> crear(@RequestBody CategoriaGasto ca){
        CategoriaGastoDTO c = repo.crear(ca);
        return ResponseEntity.created(URI.create("/api/categoriaGasto"+c.getId())).body(c);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaGastoDTO> actualziar(@PathVariable Long id, @RequestBody CategoriaGasto ca){
        return ResponseEntity.ok(repo.actualizar(id, ca));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
