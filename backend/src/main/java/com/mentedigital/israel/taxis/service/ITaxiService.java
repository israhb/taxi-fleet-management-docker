package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.TaxiDTO;
import com.mentedigital.israel.taxis.model.Taxi;

import java.util.List;

public interface ITaxiService {

    List<TaxiDTO> listado();
    TaxiDTO crear(Taxi t);
    TaxiDTO actualziar(Long id, Taxi t);
    void eliminar(Long id);

}
