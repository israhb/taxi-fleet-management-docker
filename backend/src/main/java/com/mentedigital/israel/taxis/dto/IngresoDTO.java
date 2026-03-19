package com.mentedigital.israel.taxis.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngresoDTO {

    private Long id;
    private Double monto;
    private LocalDateTime fechaHoraIngreso;
    private String notas;
    private Long creadoPor;
    private List<TaxiDTO> taxi;
    private List<ConductorDTO> conductor;
}
