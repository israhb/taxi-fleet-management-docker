package com.mentedigital.israel.taxis.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rol_id")
    private Long rolId;

    private String usuario;
    private String password;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    private Integer activo;

    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private Rol rol;
}
