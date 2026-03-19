package com.mentedigital.israel.taxis.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MantenimientoTaxiDTO {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaHoraMantenimiento;
    private Double costo;
    private LocalDate fechaProximoMantenimiento;
    private String notas;
    private Long creadoPor;
    private List<TaxiDTO> taxi;
    private List<TipoMantenimientoDTO> tipoMantenimiento;
}
