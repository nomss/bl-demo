package com.ayeeti.blservice.user;

import com.ayeeti.blservice.user.requests.CreateUserAtLocation;
import com.ayeeti.blservice.user.requests.CreateUserRequest;
import com.ayeeti.blservice.user.requests.UpdateUserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody CreateUserRequest userRequest) {
        return userService.createUser(userRequest.username(), userRequest.password());
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}") // TODO: do it right way (ResponseEntity)
    public UserDTO deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping() // TODO: FIX
    public UserDTO updateUser(@RequestBody UpdateUserRequest userUpdateUserNameRequest) {
        return userService.updateUser(userUpdateUserNameRequest.userId(), userUpdateUserNameRequest.newUserName());
    }

    @PostMapping("/createUserAtLocation")
    public UserDTO createUserAtLocation(@RequestBody CreateUserAtLocation createUserAtLocation) {
        try {
            return userService.createUserAtLocation(createUserAtLocation.getUsername(), createUserAtLocation.getPassword(), createUserAtLocation.getLocationRequests());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
