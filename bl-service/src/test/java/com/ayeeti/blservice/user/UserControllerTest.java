package com.ayeeti.blservice.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest(3L, "NewUserNameTest3");
        UserDTO user = userController.updateUser(userUpdateRequest);
        System.out.println("user: " + user);
    }

}