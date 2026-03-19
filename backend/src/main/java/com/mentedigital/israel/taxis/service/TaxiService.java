package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.TaxiDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.Taxi;
import com.mentedigital.israel.taxis.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiService implements ITaxiService{

    @Autowired
    private TaxiRepository taxiRepository;

    @Override
    public List<TaxiDTO> listado() {
        return taxiRepository.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public TaxiDTO crear(Taxi t) {
        return Mapper.toDto(taxiRepository.save(t));
    }

    @Override
    public TaxiDTO actualziar(Long id, Taxi t) {
        Taxi ta = taxiRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Not Found.."));
        ta.setNombreUnidad(t.getNombreUnidad());
        ta.setMarca(t.getMarca());
        ta.setModelo(t.getModelo());
        ta.setAnio(t.getAnio());
        ta.setColor(t.getColor());
        ta.setPlaca(t.getPlaca());
        ta.setPrecioCompra(t.getPrecioCompra());
        ta.setFechaCompra(t.getFechaCompra());
        return Mapper.toDto(taxiRepository.save(ta));
    }

    @Override
    public void eliminar(Long id) {
        if(!taxiRepository.existsById(id)) throw new NotFoundExeption("Not found..");
        taxiRepository.deleteById(id);
    }
}
