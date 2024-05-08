package com.ayeeti.blservice.location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationDtoMapper {
    /**
     * Maps a list of Location entities to a list of LocationDTOs.
     *
     * @param locations the list of Location entities
     * @return a list of LocationDTOs
     */
    public static List<LocationDTO> mapLocationsToLocationDTOs(List<Location> locations) {
        return locations.stream()
                .map(LocationDtoMapper::mapLocationToLocationDTO)
                .collect(Collectors.toList());
    }

    /**
     * Maps a single Location entity to a LocationDTO.
     *
     * @param location the Location entity
     * @return the mapped LocationDTO
     */
    private static LocationDTO mapLocationToLocationDTO(Location location) {
        if (location == null) {
            return null;
        }
        return new LocationDTO(
                location.getId(),
                location.getAirportName(),
                location.getAirportCode()
        );
    }
}
