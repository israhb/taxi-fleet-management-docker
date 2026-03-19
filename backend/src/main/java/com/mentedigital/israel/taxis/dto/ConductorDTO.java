package com.mentedigital.israel.taxis.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConductorDTO {

    private Long id;
    private String nombreCompleto;
    private String telefono;
    private String direccion;
    private String numeroLicencia;
    private LocalDate fechaContratacion;
}
