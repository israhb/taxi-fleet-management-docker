package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.AsignacionTaxiConductorDTO;
import com.mentedigital.israel.taxis.model.AsignacionTaxiConductor;

import java.util.List;

public interface IAsignacionTaxiConductorService {

    List<AsignacionTaxiConductorDTO> listado();
    AsignacionTaxiConductorDTO crear(AsignacionTaxiConductor a);
    AsignacionTaxiConductorDTO actualizar(Long id, AsignacionTaxiConductor a);
    void eliminar(Long id);
}
