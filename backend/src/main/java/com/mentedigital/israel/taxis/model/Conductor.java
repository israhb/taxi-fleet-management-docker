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
@Table(name = "conductores")
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", length = 150)
    private String nombreCompleto;
    private String telefono;
    private String direccion;

    @Column(name = "numero_licencia", length = 100)
    private String numeroLicencia;

    @Column(name = "fecha_contratacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaContratacion;

    @OneToMany(mappedBy = "conductor")
    private List<AsignacionTaxiConductor> asignacionTaxiConductor;

    @OneToMany(mappedBy = "conductor")
    private List<Ingreso> ingreso;
}
