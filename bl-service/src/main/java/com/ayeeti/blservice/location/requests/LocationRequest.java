package com.ayeeti.blservice.location.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class LocationRequest {

    private String airportName;
    private String airportCode;

}
