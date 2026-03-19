package com.mentedigital.israel.taxis.service;

import com.mentedigital.israel.taxis.dto.UsuarioDTO;
import com.mentedigital.israel.taxis.exeption.NotFoundExeption;
import com.mentedigital.israel.taxis.mapper.Mapper;
import com.mentedigital.israel.taxis.model.Usuario;
import com.mentedigital.israel.taxis.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository repo;

    @Override
    public List<UsuarioDTO> listado() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public UsuarioDTO crear(Usuario u) {
        return  Mapper.toDto(repo.save(u));
    }

    @Override
    public UsuarioDTO actualizar(Long id, Usuario u) {
        Usuario usu = repo.findById(id)
                .orElseThrow(()->new NotFoundExeption("Noy found..."));
        usu.setRolId(u.getRolId());
        usu.setUsuario(u.getUsuario());
        usu.setPassword(u.getPassword());
        usu.setNombreCompleto(u.getNombreCompleto());
        return  Mapper.toDto(repo.save(u));
    }

    @Override
    public void elimnar(Long id) {
        if(!repo.existsById(id)) throw new NotFoundExeption("Not found..");
        repo.deleteById(id);
    }
}
