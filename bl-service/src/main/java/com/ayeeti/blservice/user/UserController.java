package com.ayeeti.blservice.user;

import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(UserUpdateRequest userUpdateRequest) {
        System.out.println("userUpdateRequest: " + userUpdateRequest);
        return userService.updateUser(userUpdateRequest.userId(), userUpdateRequest.newUserName());
    }

}
