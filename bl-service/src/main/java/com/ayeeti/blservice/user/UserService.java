package com.ayeeti.blservice.user;


import com.ayeeti.blservice.location.LocationMapper;
import jakarta.persistence.EntityNotFoundException;
import com.ayeeti.blservice.location.Location;
import com.ayeeti.blservice.location.LocationMapper;
import com.ayeeti.blservice.location.LocationService;
import com.ayeeti.blservice.location.requests.LocationRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final LocationService locationService;

    public UserService(IUserRepository userRepository, LocationService locationService) {
        this.userRepository = userRepository;
        this.locationService = locationService;
    }

    public UserDTO createUser(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        User result = userRepository.save(user);
        return new UserDTO(result.getId(), result.getUsername(), null, null);
    }

    @Transactional
    public UserDTO createUserAtLocation(String username, String password, Set<LocationRequest> locationRequest) throws Exception {
        if (locationRequest == null || locationRequest.isEmpty()) {
            throw new RuntimeException("Airport Code cannot be empty");
        }
        Set<String> airportCoeds = new HashSet<>();
        for (LocationRequest locationReq: locationRequest) {
            airportCoeds.add(locationReq.getAirportCode());
        }

        Set<Location> location = locationService.findByAirportCodes(airportCoeds);
        if (location == null || location.isEmpty()) {
            throw new RuntimeException("Location could not be found. Please create the Location first.");
        }

        User user = User.builder()
                .username(username)
                .password(password)
                .locations(location)
                .build();
        User result = userRepository.save(user);
        return UserMapper.mapUserToUserDTO(result);
    }

    public UserDTO getUser(Long userId) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.orElseThrow(() -> new RuntimeException("No user found with ID: " + userId));
        return new UserDTO(user.getId(), user.getUsername(), LocationMapper.mapLocationsToLocationDTOs(user.getLocations()), null);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDTO(user.getId(), user.getUsername(), LocationMapper.mapLocationsToLocationDTOs(user.getLocations()), null)).toList();
    }

    public UserDTO deleteUser(Long userId) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.orElseThrow(() -> new RuntimeException("No user found with ID: " + userId));
        UserDTO userDTO = UserMapper.mapUserToUserDTO(user);
        userRepository.deleteById(userId);
        userDTO.setErrorMessage("User Deleted Successfully");
        return userDTO;
    }

    public UserDTO updateUser(Long userId, String userName) { // we just update username for simplicity
        Optional<User> result = userRepository.findById(userId);
        User user = result.orElseThrow(() -> new RuntimeException("No user found with ID: " + userId));
        user.setUsername(userName);
        User updatedUser = userRepository.save(user);
        return new UserDTO(updatedUser.getId(), updatedUser.getUsername(), LocationMapper.mapLocationsToLocationDTOs(user.getLocations()), null);
    }
}
