package com.ayeeti.blservice.user;

import com.ayeeti.blservice.location.LocationDTO;
import com.ayeeti.blservice.location.LocationMapper;

import java.util.Set;

public class UserMapper {

    public static UserDTO mapUserToUserDTO(User user) {
        Set<LocationDTO> locationDTO = LocationMapper.mapLocationsToLocationDTOs(user.getLocations());
        return new UserDTO(user.getId(), user.getUsername(), locationDTO, null);
    }

}
