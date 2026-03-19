package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.CategoriaGastoDTO;
import com.mentedigital.israel.taxis.model.CategoriaGasto;

import java.util.List;

public interface ICategoriaGastoService {

    List<CategoriaGastoDTO> listado();
    CategoriaGastoDTO crear(CategoriaGasto c);
    CategoriaGastoDTO actualizar(Long id, CategoriaGasto c);
    void eliminar(Long id);

}
