package com.mentedigital.israel.taxis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asignaciones_taxi_conductor")
public class AsignacionTaxiConductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taxi_id")
    private Long taxiId;

    @Column(name = "conductor_id")
    private Long conductorId;

    @Column(name = "fecha_inicio")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;

    private Integer activo;

    @ManyToOne
    @JoinColumn(name = "conductor_id", insertable = false, updatable = false)
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "taxi_id", insertable = false, updatable = false)
    private Taxi taxi;
}
