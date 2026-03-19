package com.mentedigital.israel.taxis.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;
    private String usuario;
    private String password;
    private String nombreCompleto;
    private Integer activo;

    private List<RolDTO> rol;
}
