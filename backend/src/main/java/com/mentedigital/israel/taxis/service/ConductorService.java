package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.ConductorDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.Conductor;
import com.mentedigital.israel.taxis.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService implements IConductorService{

    @Autowired
    private ConductorRepository repo;

    @Override
    public List<ConductorDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public ConductorDTO crear(Conductor c) {
        return Mapper.toDto(repo.save(c));
    }

    @Override
    public ConductorDTO actualizar(Long id, Conductor c) {
        Conductor co = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        co.setNombreCompleto(c.getNombreCompleto());
        co.setTelefono(c.getTelefono());
        co.setDireccion(c.getDireccion());
        co.setNumeroLicencia(c.getNumeroLicencia());
        co.setFechaContratacion(c.getFechaContratacion());
        return Mapper.toDto(repo.save(co));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
