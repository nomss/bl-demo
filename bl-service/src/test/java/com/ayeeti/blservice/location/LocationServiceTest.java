package com.ayeeti.blservice.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    void saveLocation() {
        locationService.saveLocation("John", "JFK");
    }
}