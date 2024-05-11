package com.ayeeti.blservice.user;

import com.ayeeti.blservice.user.requests.CreateUserAtLocationRequest;
import com.ayeeti.blservice.user.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest.username(), userRequest.password());
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build(); // sends STATUS 200
    }

    @PutMapping()
    public UserDTO updateUser(@RequestBody UserRequest userRequest) {
        return userService.updateUser(userRequest.id(), userRequest.username()); // we update just the username for simplicity
    }

    @PostMapping("createAtLocation")
    public UserDTO createUserAtLocation(@RequestBody CreateUserAtLocationRequest createUserAtLocationRequest) {
        try {
            return userService.createUserAtLocation(createUserAtLocationRequest.getUsername(), createUserAtLocationRequest.getPassword(), createUserAtLocationRequest.getLocationRequests());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
