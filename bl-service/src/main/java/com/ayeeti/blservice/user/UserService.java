package com.ayeeti.blservice.user;


import com.ayeeti.blservice.location.LocationMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        User result = userRepository.save(user);
        return new UserDTO(result.getId(), result.getUsername(), null);
    }

    public UserDTO getUser(Long userId) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.orElseThrow(() -> new RuntimeException("No user found with ID: " + userId));
        return new UserDTO(user.getId(), user.getUsername(), LocationMapper.mapLocationsToLocationDTOs(user.getLocations()));
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDTO(user.getId(), user.getUsername(), LocationMapper.mapLocationsToLocationDTOs(user.getLocations()))).toList();
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("No user found with ID: " + userId));
        userRepository.delete(user);
    }

    public UserDTO updateUser(Long userId, String userName) { // we just update username for simplicity
        Optional<User> result = userRepository.findById(userId);
        User user = result.orElseThrow(() -> new RuntimeException("No user found with ID: " + userId));
        user.setUsername(userName);
        User updatedUser = userRepository.save(user);
        return new UserDTO(updatedUser.getId(), updatedUser.getUsername(), LocationMapper.mapLocationsToLocationDTOs(user.getLocations()));
    }
}
