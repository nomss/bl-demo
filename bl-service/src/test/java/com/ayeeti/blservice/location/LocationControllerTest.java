package com.ayeeti.blservice.location;

import com.ayeeti.blservice.location.requests.LocationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocationControllerTest {

    @Autowired
    private LocationController locationController;
    @Test
    void createLocation() {
        LocationRequest locationRequest = new LocationRequest("J2", "J2");
        locationController.createLocation(locationRequest);
    }
}