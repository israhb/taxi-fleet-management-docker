package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.GastoDTO;
import com.mentedigital.israel.taxis.model.Gasto;

import java.util.List;

public interface IGastoService {

    List<GastoDTO> listado();
    GastoDTO crear(Gasto g);
    GastoDTO actualizar(Long id, Gasto c);
    void eliminar(Long id);

}
