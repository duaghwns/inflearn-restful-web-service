package com.example.restfulwebservice.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String Hello(){
        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld(){

        return "Hello World";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world");
    }

    @GetMapping("path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }

    @GetMapping("board/{boardNo}")
    public String boardNo(@PathVariable int boardNo){
        return "board : " + boardNo;
    }


}