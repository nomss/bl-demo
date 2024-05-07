package com.ayeeti.blservice.user;


import org.springframework.stereotype.Service;

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
        return new UserDTO(result.getId(), result.getUsername());
    }
}
