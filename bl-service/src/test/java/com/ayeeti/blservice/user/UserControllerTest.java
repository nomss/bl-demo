package com.ayeeti.blservice.user;

import com.ayeeti.blservice.location.requests.LocationRequest;
import com.ayeeti.blservice.user.request.UserRequest;
import com.ayeeti.blservice.user.requests.CreateUserAtLocationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void testGetUser() {
        UserDTO user = userController.getUser(3L);
        System.out.println("user: " + user);
    }

    @Test
    public void updateUser() {
        UserRequest userRequest = new UserRequest(1L, "TEST New User", "p");
        UserDTO user = userController.updateUser(userRequest);
        System.out.println("user: " + user);
    }

    @Test
    public void createUserAtLocationTest() {
        LocationRequest locationRequest = new LocationRequest("John", "JFK");
        CreateUserAtLocationRequest createUserAtLocationRequest = CreateUserAtLocationRequest.builder()
                .username("UserAtJFK")
                .password("Pass")
                .locationRequests(Set.of(locationRequest))
                .build();
        UserDTO userDTO = userController.createUserAtLocation(createUserAtLocationRequest);
        System.out.println("userDTO: " + userDTO);
    }

}