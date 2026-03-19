package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.UsuarioDTO;
import com.mentedigital.israel.taxis.dto.auth.UsuarioRequestDTO;
import com.mentedigital.israel.taxis.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioDTO> listado();
    UsuarioDTO crear(Usuario u);
    UsuarioDTO actualizar(Long id, Usuario u);
    void elimnar(Long id);
    //logica aparte
    UsuarioRequestDTO login(String user, String password);
}
