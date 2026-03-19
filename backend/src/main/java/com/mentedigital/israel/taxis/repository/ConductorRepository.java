package com.mentedigital.israel.taxis.repository;

import com.mentedigital.israel.taxis.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}
