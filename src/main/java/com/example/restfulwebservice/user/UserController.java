package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    // 생성자를 통한 의존성 주입
    public UserController(UserDaoService service){
        this.service = service;
    }

    @GetMapping("users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("users/{id}")
    public User saveUser(@PathVariable int id){
        User user = service.findOne(id);
        service.save(user);
        return service.findOne(id);
    }

}
