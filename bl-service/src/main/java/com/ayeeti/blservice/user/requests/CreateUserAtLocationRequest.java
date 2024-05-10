package com.ayeeti.blservice.user.requests;

import com.ayeeti.blservice.location.requests.LocationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CreateUserAtLocationRequest {

    private String username;
    private String password;
    private Set<LocationRequest> locationRequests;

}
