package com.mentedigital.israel.taxis.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignacionTaxiConductorDTO {

    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer activo;
    private List<TaxiDTO> taxi;
    private List<ConductorDTO> conductor;
}
