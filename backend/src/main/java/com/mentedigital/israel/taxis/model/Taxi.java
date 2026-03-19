package com.mentedigital.israel.taxis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taxis")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_unidad", length = 100)
    private String nombreUnidad;

    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private String placa;

    @Column(name = "precio_compra")
    private String precioCompra;

    @Column(name = "fecha_compra")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCompra;

    @OneToMany(mappedBy = "taxi")
    private List<AsignacionTaxiConductor> asignacionTaxiConductor;

    @OneToMany(mappedBy = "taxi")
    private List<Gasto> gasto;

    @OneToMany(mappedBy = "taxi")
    private List<Ingreso> ingreso;

    @OneToMany(mappedBy = "taxi")
    private List<MantenimientoTaxi> mantenimientoTaxi;
}
