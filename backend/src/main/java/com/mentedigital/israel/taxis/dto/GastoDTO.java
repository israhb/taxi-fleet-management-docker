package com.mentedigital.israel.taxis.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GastoDTO {

    private Long id;
    private String descripcion;
    private Double monto;
    private LocalDateTime fechaHoraGasto;
    private String notas;
    private Long creadoPor;
    private List<TaxiDTO> taxi;
    private List<CategoriaGastoDTO> categoriaGasto;
}
