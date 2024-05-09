package com.ayeeti.blservice.user;

import com.ayeeti.blservice.location.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private Set<LocationDTO> locationDTO;
    private String errorMessage;

}
