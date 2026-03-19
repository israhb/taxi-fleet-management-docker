package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.TipoMantenimientoDTO;
import com.mentedigital.israel.taxis.model.TipoMantenimiento;

import java.util.List;

public interface ITipoMantenimientoService {

    List<TipoMantenimientoDTO> listado();
    TipoMantenimientoDTO crear(TipoMantenimiento tm);
    TipoMantenimientoDTO actualizar(Long id, TipoMantenimiento tm);
    void eliminar(Long id);

}
