package com.mentedigital.israel.taxis.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxiDTO {

    private Long id;
    private String nombreUnidad;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private String placa;
    private String precioCompra;
    private LocalDate fechaCompra;
}
