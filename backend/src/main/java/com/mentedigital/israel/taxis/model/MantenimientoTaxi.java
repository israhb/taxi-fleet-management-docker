package com.mentedigital.israel.taxis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mantenimientos_taxi")
public class MantenimientoTaxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taxi_id")
    private Long taxiId;

    @Column(name = "tipo_mantenimiento_id")
    private Long tipoMantenimientoId;

    private String descripcion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_hora_mantenimiento")
    private LocalDateTime fechaHoraMantenimiento;

    private Double costo;

    @Column(name = "fecha_proximo_mantenimiento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaProximoMantenimiento;

    private String notas;

    @Column(name = "creado_por")
    private Long creadoPor;

    @ManyToOne
    @JoinColumn(name = "taxi_id", insertable = false, updatable = false)
    private Taxi taxi;

    @ManyToOne
    @JoinColumn(name = "tipo_mantenimiento_id", insertable = false, updatable = false)
    private TipoMantenimiento tipoMantenimiento;
}
