package com.ayeeti.blservice.user;

import com.ayeeti.blservice.location.requests.LocationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Test
    public void createUser() {
        userService.createUser("Test1", "TestP1");
    }

    @Test
    public void testUserServiceGet() {
        userService.getUser(3L);
    }

    @Test
    public void testUserServiceUpdate() {
        UserDTO userDTO = userService.updateUser(1L, "TestUpdated1");
        System.out.println("userDTO: " + userDTO);
    }

    @Test
    public void testUserServiceDelete() {
        userService.deleteUser(1L);
    }

    @Test
    public void testGetUser() {
        UserDTO user = userController.getUser(3L);
        System.out.println("user: " + user);
    }

    @Test
    void createUserAtLocation() {
        LocationRequest locationRequest = new LocationRequest("John", "JFK");
        try {
            userService.createUserAtLocation("Test1", "P2", Set.of(locationRequest));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}