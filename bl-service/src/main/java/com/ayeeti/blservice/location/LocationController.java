package com.ayeeti.blservice.location;

import com.ayeeti.blservice.location.requests.LocationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/createLocation")
    public LocationDTO createLocation(@RequestBody LocationRequest locationRequest) {
        Location location = locationService.createLocation(locationRequest.getAirportName(), locationRequest.getAirportCode());
        return LocationMapper.mapLocationToLocationDTO(location);
    }

    @GetMapping("/{airportCode}")
    public LocationDTO getLocation(@PathVariable String airportCode) {
        Location location = locationService.findByAirportCode(airportCode);
        return LocationMapper.mapLocationToLocationDTO(location);
    }

}
