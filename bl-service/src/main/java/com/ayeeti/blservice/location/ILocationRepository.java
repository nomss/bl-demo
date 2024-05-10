package com.ayeeti.blservice.location;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILocationRepository extends JpaRepository<Location, Long> {
    // no need to write the HQL/SQL here - Spring understands from method name
    Optional<Location> findByAirportCode(String airportCode);
}
