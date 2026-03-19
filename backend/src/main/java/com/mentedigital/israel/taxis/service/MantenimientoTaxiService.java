package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.MantenimientoTaxiDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.MantenimientoTaxi;
import com.mentedigital.israel.taxis.repository.MantenimientoTaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenimientoTaxiService implements IMantenimientoTaxiService{

    @Autowired
    private MantenimientoTaxiRepository repo;

    @Override
    public List<MantenimientoTaxiDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public MantenimientoTaxiDTO crear(MantenimientoTaxi m) {
        return Mapper.toDto(repo.save(m));
    }

    @Override
    public MantenimientoTaxiDTO actualziar(Long id, MantenimientoTaxi m) {
        MantenimientoTaxi man = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        man.setTaxiId(m.getTaxiId());
        man.setTipoMantenimientoId(m.getTipoMantenimientoId());
        man.setDescripcion(m.getDescripcion());
        man.setFechaHoraMantenimiento(m.getFechaHoraMantenimiento());
        man.setCosto(m.getCosto());
        man.setFechaProximoMantenimiento(m.getFechaProximoMantenimiento());
        man.setNotas(m.getNotas());
        man.setCreadoPor(m.getCreadoPor());
        return Mapper.toDto(repo.save(man));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
