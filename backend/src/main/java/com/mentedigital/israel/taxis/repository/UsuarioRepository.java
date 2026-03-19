package com.mentedigital.israel.taxis.repository;

import com.mentedigital.israel.taxis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
