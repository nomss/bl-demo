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

    @GetMapping("/getUser")
    public UserDTO createUser() {
        return userService.getUser(1L);
    }

}
