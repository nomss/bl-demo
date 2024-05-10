package com.ayeeti.blservice.location;

import com.ayeeti.blservice.location.request.LocationRequest;
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

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationRequest locationRequest) {
        LocationDTO createdLocation = locationService.createLocation(locationRequest.airportName(), locationRequest.airportCode());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLocation);
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<LocationDTO> locations = locationService.getAllLocations();
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
        LocationDTO locationDTO = locationService.updateLocation(locationRequest.airportName(), locationRequest.airportCode());
        return ResponseEntity.ok(locationDTO);
    }
}
