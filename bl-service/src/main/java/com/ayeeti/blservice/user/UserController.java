package com.ayeeti.blservice.user;

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
        System.out.println("userRequest: " + userRequest);
        return userService.createUser(userRequest.getUsername(), userRequest.getPassword());
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
        return userService.updateUser(userRequest.getId(), userRequest.getUsername()); // we update just the username for simplicity
    }

}
