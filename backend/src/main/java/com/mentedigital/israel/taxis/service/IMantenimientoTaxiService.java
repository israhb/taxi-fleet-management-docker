package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.MantenimientoTaxiDTO;
import com.mentedigital.israel.taxis.model.MantenimientoTaxi;

import java.util.List;

public interface IMantenimientoTaxiService {

    List<MantenimientoTaxiDTO> listado();
    MantenimientoTaxiDTO crear(MantenimientoTaxi m);
    MantenimientoTaxiDTO actualziar(Long id, MantenimientoTaxi m);
    void eliminar(Long id);

}
