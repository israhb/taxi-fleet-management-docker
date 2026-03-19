package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.GastoDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.Gasto;
import com.mentedigital.israel.taxis.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService implements IGastoService{

    @Autowired
    private GastoRepository repo;

    @Override
    public List<GastoDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public GastoDTO crear(Gasto g) {
        return Mapper.toDto(repo.save(g));
    }

    @Override
    public GastoDTO actualizar(Long id, Gasto c) {
        Gasto gasto = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        gasto.setTaxiId(c.getTaxiId());
        gasto.setConductorId(c.getConductorId());
        gasto.setDescripcion(c.getDescripcion());
        gasto.setMonto(c.getMonto());
        gasto.setFechaHoraGasto(c.getFechaHoraGasto());
        gasto.setNotas(c.getNotas());
        gasto.setCreadoPor(c.getCreadoPor());
        return Mapper.toDto(repo.save(gasto));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
