package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.AsignacionTaxiConductorDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.AsignacionTaxiConductor;
import com.mentedigital.israel.taxis.repository.AsignacionTaxiConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionTaxiConductorService implements IAsignacionTaxiConductorService{

    @Autowired
    private AsignacionTaxiConductorRepository repo;

    @Override
    public List<AsignacionTaxiConductorDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public AsignacionTaxiConductorDTO crear(AsignacionTaxiConductor a) {
        return Mapper.toDto(repo.save(a));
    }

    @Override
    public AsignacionTaxiConductorDTO actualizar(Long id, AsignacionTaxiConductor a) {
        AsignacionTaxiConductor as = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        as.setTaxiId(a.getTaxiId());
        as.setConductorId(a.getConductorId());
        as.setConductor(a.getConductor());
        as.setFechaInicio(a.getFechaInicio());
        as.setFechaFin(a.getFechaFin());
        return Mapper.toDto(repo.save(a));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
