package com.ayeeti.blservice.location;

import com.ayeeti.blservice.location.requests.LocationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    void saveLocation() {
        LocationRequest locationRequest = LocationRequest.builder()
                .airportName("John2")
                .airportCode("JFK2")
                .build();
        locationService.createLocation(locationRequest);
    }
}