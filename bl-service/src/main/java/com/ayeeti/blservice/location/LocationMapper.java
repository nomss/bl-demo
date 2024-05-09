package com.ayeeti.blservice.location;

import java.util.Set;
import java.util.stream.Collectors;

public class LocationMapper {
    /**
     * Maps a list of Location entities to a list of LocationDTOs.
     *
     * @param locations the list of Location entities
     * @return a Set of LocationDTOs
     */
    public static Set<LocationDTO> mapLocationsToLocationDTOs(Set<Location> locations) {
        return locations.stream()
                .map(LocationMapper::mapLocationToLocationDTO)
                .collect(Collectors.toSet());
    }

    /**
     * Maps a single Location entity to a LocationDTO.
     *
     * @param location the Location entity
     * @return the mapped LocationDTO
     */
    public static LocationDTO mapLocationToLocationDTO(Location location) {
        if (location == null) {
            return null;
        }
        return new LocationDTO(
                location.getId(),
                location.getAirportName(),
                location.getAirportCode()
        );
    }

//    public static Location mapLocationRequestToLocation(LocationRequest locationRequest) {
//
//    }

//    private static Location mapToLocation(LocationRequest locationRequest) {
//        if (locationRequest == null) {
//            return null;
//        }
//        return new LocationDTO(
//                location.getId(),
//                location.getAirportName(),
//                location.getAirportCode()
//        );
//    }

}
