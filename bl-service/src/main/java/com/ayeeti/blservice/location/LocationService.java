package com.ayeeti.blservice.location;

import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class LocationService {

    private final ILocationRepository locationRepository;

    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(String airportName, String aiportCode) {
        Location location = Location.builder()
                .airportName(airportName)
                .airportCode(aiportCode)
                .build();
        locationRepository.save(location);
        return location;
    }

    public Location findByAirportCode(String airportCode) {
        return locationRepository.findByAirportCode(airportCode);
    }

    public Set<Location> findByAirportCodes(Set<String> airportCodes) {
        return locationRepository.findByAirportCodeIn(airportCodes);
    }

}
