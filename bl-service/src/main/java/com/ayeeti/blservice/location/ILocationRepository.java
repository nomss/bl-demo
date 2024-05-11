package com.ayeeti.blservice.location;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByAirportCode(String airportCode);
    Set<Location> findByAirportCodeIn(Set<String> airportCode);
}
