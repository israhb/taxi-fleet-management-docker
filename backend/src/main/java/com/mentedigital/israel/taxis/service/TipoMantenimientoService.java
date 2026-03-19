package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.TipoMantenimientoDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.TipoMantenimiento;
import com.mentedigital.israel.taxis.repository.TipoMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMantenimientoService implements ITipoMantenimientoService{

    @Autowired
    private TipoMantenimientoRepository repo;

    @Override
    public List<TipoMantenimientoDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public TipoMantenimientoDTO crear(TipoMantenimiento tm) {
        return Mapper.toDto(repo.save(tm));
    }

    @Override
    public TipoMantenimientoDTO actualizar(Long id, TipoMantenimiento tm) {
        TipoMantenimiento tf = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        tf.setNombre(tm.getNombre());
        return Mapper.toDto(repo.save(tf));
    }

    @Override
    public void eliminar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
