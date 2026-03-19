package com.mentedigital.israel.taxis.repository;

import com.mentedigital.israel.taxis.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
}
