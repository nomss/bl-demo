package com.ayeeti.blservice.location;

import com.ayeeti.blservice.location.requests.LocationRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LocationService {

    private final ILocationRepository locationRepository;

    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }



    public LocationDTO getLocation(String airportCode) {
        Location result = locationRepository.findByAirportCode(airportCode).orElseThrow(() -> new EntityNotFoundException("No location found with Airport Code: " + airportCode));
        return LocationMapper.mapLocationToLocationDTO(result);
    }

    public Set<Location> getAllLocations() {
                return (Set<Location>) locationRepository.findAll();
    }

    public void deleteLocation(String airportCode) {
        Location location = locationRepository.findByAirportCode(airportCode).orElseThrow(() -> new EntityNotFoundException("No location found with Airport Code: " + airportCode));
        locationRepository.delete(location);
    }

    /**
     * we are searching by airportCode -> that way frontend doesn't need to care about db IDs
     */
    public Location updateLocation(LocationRequest locationRequest) {
        Location location = locationRepository.findByAirportCode(locationRequest.getAirportCode()).orElseThrow(() -> new EntityNotFoundException("No location found with Airport Code: " + locationRequest.getAirportName()));
        location.setAirportName(locationRequest.getAirportName());
        location.setAirportCode(locationRequest.getAirportCode());
        return locationRepository.save(location);
    }

    public Location createLocation(LocationRequest locationRequest) {
        if(locationRequest != null && !locationRequest.getAirportCode().isEmpty() && !locationRequest.getAirportName().isEmpty()) {
            Location location = Location.builder()
                    .airportName(locationRequest.getAirportName())
                    .airportCode(locationRequest.getAirportCode())
                    .build();
            return locationRepository.save(location);
        }
        return null;
    }

    public Location findByAirportCode(String airportCode) {
        Optional<Location> location = locationRepository.findByAirportCode(airportCode);
        return location.orElse(null);
    }

    public Set<Location> findByAirportCodes(Set<String> airportCodes) {
        return locationRepository.findByAirportCodeIn(airportCodes);
    }

}
