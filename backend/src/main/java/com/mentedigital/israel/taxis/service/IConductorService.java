package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.ConductorDTO;
import com.mentedigital.israel.taxis.model.Conductor;

import java.util.List;

public interface IConductorService {

    List<ConductorDTO> listado();
    ConductorDTO crear(Conductor c);
    ConductorDTO actualizar(Long id, Conductor c);
    void eliminar(Long id);

}
