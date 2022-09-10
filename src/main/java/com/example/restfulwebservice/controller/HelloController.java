package com.example.restfulwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String Hello(){
        //GET


        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld(){

        return "Hello World";
    }
}
