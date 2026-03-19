package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.CategoriaGastoDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.CategoriaGasto;
import com.mentedigital.israel.taxis.repository.CategoriaGastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaGastoService implements ICategoriaGastoService{

    @Autowired
    private CategoriaGastoRepository repo;

    @Override
    public List<CategoriaGastoDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public CategoriaGastoDTO crear(CategoriaGasto c) {
        return Mapper.toDto(repo.save(c));
    }

    @Override
    public CategoriaGastoDTO actualizar(Long id, CategoriaGasto c) {
        CategoriaGasto ca = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        ca.setNombre(c.getNombre());
        return Mapper.toDto(repo.save(ca));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
