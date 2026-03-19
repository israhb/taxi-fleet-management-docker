package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.IngresoDTO;
import com.mentedigital.israel.taxis.model.Ingreso;

import java.util.List;

public interface IIngresoService {

    List<IngresoDTO> listado();
    IngresoDTO crear(Ingreso in);
    IngresoDTO actualziar(Long id, Ingreso in);
    void eliminar(Long id);

}
