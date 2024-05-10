package com.ayeeti.blservice.location;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final ILocationRepository locationRepository;

    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationDTO createLocation(String airportName, String airportCode) {
        Location location = Location.builder()
                .airportName(airportName)
                .airportCode(airportCode)
                .build();
        Location result = locationRepository.save(location);
        return LocationMapper.mapLocationToLocationDTO(result);
    }

    public LocationDTO getLocation(String airportCode) {
        Location result = locationRepository.findByAirportCode(airportCode).orElseThrow(() -> new EntityNotFoundException("No location found with Airport Code: " + airportCode));
        return LocationMapper.mapLocationToLocationDTO(result);
    }

    public List<LocationDTO> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return LocationMapper.mapLocationsToLocationDTOs(locations);
    }

    public void deleteLocation(String airportCode) {
        Location location = locationRepository.findByAirportCode(airportCode).orElseThrow(() -> new EntityNotFoundException("No location found with Airport Code: " + airportCode));
        locationRepository.delete(location);
    }

    /**
     * we are searching by airportCode -> that way frontend doesn't need to care about db IDs
     */
    public LocationDTO updateLocation(String airportName, String airportCode) {
        Location location = locationRepository.findByAirportCode(airportCode).orElseThrow(() -> new EntityNotFoundException("No location found with Airport Code: " + airportCode));
        location.setAirportName(airportName);
        location.setAirportCode(airportCode);
        locationRepository.save(location);
        return LocationMapper.mapLocationToLocationDTO(location);
    }
}
