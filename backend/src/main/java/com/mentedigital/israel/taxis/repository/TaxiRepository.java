package com.mentedigital.israel.taxis.repository;

import com.mentedigital.israel.taxis.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {
}
