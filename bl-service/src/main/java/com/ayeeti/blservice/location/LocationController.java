package com.ayeeti.blservice.location;

import com.ayeeti.blservice.location.requests.LocationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationRequest locationRequest) {
        Location createdLocation = locationService.createLocation(locationRequest);
        LocationDTO locationDTO = LocationMapper.mapLocationToLocationDTO(createdLocation);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationDTO);
    }

    @GetMapping
    public ResponseEntity<Set<LocationDTO>> getAllLocations() {
        Set<Location> allLocations = locationService.getAllLocations();
        Set<LocationDTO> locations = LocationMapper.mapLocationsToLocationDTOs(allLocations);
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{airportCode}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable String airportCode) {
        LocationDTO location = locationService.getLocation(airportCode);
        return ResponseEntity.ok(location);
    }

    @DeleteMapping("/{airportCode}")
    public ResponseEntity<Void> deleteLocation(@PathVariable String airportCode) {
        locationService.deleteLocation(airportCode);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<LocationDTO> updateUser(@RequestBody LocationRequest locationRequest) {
        Location location = locationService.updateLocation(locationRequest);
        LocationDTO locationDTO = LocationMapper.mapLocationToLocationDTO(location);
        return ResponseEntity.ok(locationDTO);
    }
}
