package com.mentedigital.israel.taxis.dto.auth;

import com.mentedigital.israel.taxis.dto.RolDTO;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequestDTO {
    private Long id;
    private String usuario;
    private String nombreCompleto;
    private List<RolDTO> rol;
}
