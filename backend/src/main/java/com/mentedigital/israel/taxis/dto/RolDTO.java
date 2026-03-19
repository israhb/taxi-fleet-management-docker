package com.mentedigital.israel.taxis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolDTO {

    private Long id;
    private String nombre;
    private String descripcion;

}
