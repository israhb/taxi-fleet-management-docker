package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.RolDTO;
import com.mentedigital.israel.taxis.model.Rol;

import java.util.List;

public interface IRolService {

    List<RolDTO> listado();
    RolDTO crear(Rol r);
    RolDTO actualizar(Long id, Rol r);
    void eliminar(Long id);

}
