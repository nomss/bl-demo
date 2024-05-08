package com.ayeeti.blservice;

import com.ayeeti.blservice.user.IUserRepository;
import com.ayeeti.blservice.user.UserController;
import com.ayeeti.blservice.user.UserDTO;
import com.ayeeti.blservice.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private IUserRepository userRepository;

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

}
