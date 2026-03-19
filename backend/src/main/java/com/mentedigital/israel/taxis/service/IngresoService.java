package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.IngresoDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.Ingreso;
import com.mentedigital.israel.taxis.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoService implements IIngresoService{

    @Autowired
    private IngresoRepository repo;

    @Override
    public List<IngresoDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public IngresoDTO crear(Ingreso in) {
        return Mapper.toDto(repo.save(in));
    }

    @Override
    public IngresoDTO actualziar(Long id, Ingreso in) {
        Ingreso i = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        i.setTaxiId(in.getTaxiId());
        i.setConductorId(i.getConductorId());
        i.setMonto(i.getMonto());
        i.setFechaHoraIngreso(i.getFechaHoraIngreso());
        i.setNotas(i.getNotas());
        i.setCreadoPor(i.getCreadoPor());
        return Mapper.toDto(repo.save(i));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
