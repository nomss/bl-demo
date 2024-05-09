package com.ayeeti.blservice.user;

import com.ayeeti.blservice.location.requests.LocationRequest;
import com.ayeeti.blservice.user.requests.CreateUserAtLocation;
import com.ayeeti.blservice.user.requests.UpdateUserRequest;
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
        UpdateUserRequest userUpdateUserNameRequest = new UpdateUserRequest(3L, "NewUserNameTest3");
        UserDTO user = userController.updateUser(userUpdateUserNameRequest);
        System.out.println("user: " + user);
    }

    @Test
    public void createUserAtLocationTest() {
        LocationRequest locationRequest = new LocationRequest("John", "JFK");
        CreateUserAtLocation createUserAtLocation = CreateUserAtLocation.builder()
                .username("UserAtJFK")
                .password("Pass")
                .locationRequests(Set.of(locationRequest))
                .build();
        UserDTO userDTO = userController.createUserAtLocation(createUserAtLocation);
        System.out.println("userDTO: " + userDTO);
    }

}