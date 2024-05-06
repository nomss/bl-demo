package com.ayeeti.blservice.controller;

import com.ayeeti.blservice.model.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloWorld hello() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("Hello");
        return helloWorld;
    }

}
