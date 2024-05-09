package com.ayeeti.blservice.user;


import com.ayeeti.blservice.location.LocationDtoMapper;
import org.springframework.stereotype.Service;

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
        return new UserDTO(user.getId(), user.getUsername(), LocationDtoMapper.mapLocationsToLocationDTOs(user.getLocations()));
    }

    public UserDTO deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return new UserDTO(null, null, null); // TODO: Use responseEntitiy here
    }

    public UserDTO updateUser(Long userId, String userName) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.orElseThrow(() -> new RuntimeException("No user found with ID: " + userId));
        user.setUsername(userName);
        User updatedUser = userRepository.save(user);
        return new UserDTO(updatedUser.getId(), updatedUser.getUsername(), null);
    }
}
