package com.ayeeti.blservice.user;

import com.ayeeti.blservice.location.LocationDTO;

public record UserDTO(Long id, String username, java.util.List<LocationDTO> locationDTO) {
}
