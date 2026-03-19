package com.mentedigital.israel.taxis.controller;

import com.mentedigital.israel.taxis.dto.auth.LoginRequestDTO;
import com.mentedigital.israel.taxis.dto.UsuarioDTO;
import com.mentedigital.israel.taxis.dto.auth.UsuarioRequestDTO;
import com.mentedigital.israel.taxis.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUsuarioService repo;

    @PostMapping("/login")
    public ResponseEntity<UsuarioRequestDTO> login(@RequestBody LoginRequestDTO loginReq) {
        return ResponseEntity.ok(repo.login(loginReq.getUsuario(), loginReq.getPassword()));
    }

}
