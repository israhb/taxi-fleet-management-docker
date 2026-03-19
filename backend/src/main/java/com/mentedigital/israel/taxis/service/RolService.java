package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.RolDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.Rol;
import com.mentedigital.israel.taxis.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService{

    @Autowired
    RolRepository repo;

    @Override
    public List<RolDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public RolDTO crear(Rol r) {
        return Mapper.toDto(repo.save(r));
    }

    @Override
    public RolDTO actualizar(Long id, Rol r) {
        Rol rol = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        rol.setNombre(r.getNombre());
        rol.setDescripcion(r.getDescripcion());
        return Mapper.toDto(repo.save(r));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
