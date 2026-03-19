package com.mentedigital.israel.taxis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingresos")
public class Ingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taxi_id")
    private Long taxiId;

    @Column(name = "conductor_id")
    private Long conductorId;

    private Double monto;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_hora_ingreso")
    private LocalDateTime fechaHoraIngreso;

    private String notas;

    @Column(name = "creado_por")
    private Long creadoPor;

    @ManyToOne
    @JoinColumn(name = "taxi_id", insertable = false, updatable = false)
    private Taxi taxi;

    @ManyToOne
    @JoinColumn(name = "conductor_id", insertable = false, updatable = false)
    private Conductor conductor;
}
