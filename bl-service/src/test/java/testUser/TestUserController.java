package com.ayeeti.testUser;

import com.ayeeti.blservice.user.IUserRepository;
import com.ayeeti.blservice.user.UserController;
import com.ayeeti.blservice.user.UserDTO;
import com.ayeeti.blservice.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserController {

    @Autowired
    private UserController userController;

//    @Autowired
//    private UserService userService;

//    @Autowired
//    private IUserRepository userRepository;

    @Test
    public void testGetUser() {
        UserDTO user = userController.getUser();
        System.out.println("user: " + user);
    }

}
