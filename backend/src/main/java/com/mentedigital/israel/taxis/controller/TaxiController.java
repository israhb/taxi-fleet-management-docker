package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.TaxiDTO;
import com.mentedigital.israel.taxis.model.Taxi;
import com.mentedigital.israel.taxis.service.ITaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/taxi")
public class TaxiController {

    @Autowired
    private ITaxiService repo;

    @GetMapping
    public ResponseEntity<List<TaxiDTO>> listado(){
        return ResponseEntity.ok(repo.listado());
    }
    @PostMapping
    public ResponseEntity<TaxiDTO> crear(@RequestBody Taxi t){
        TaxiDTO ft = repo.crear(t);
        return ResponseEntity.created(URI.create("/api/taxi"+ft.getId())).body(ft);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaxiDTO> actualizar(@PathVariable Long id, @RequestBody Taxi t){
       return ResponseEntity.ok(repo.actualziar(id,t));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        repo.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
