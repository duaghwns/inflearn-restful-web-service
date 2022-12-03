package com.example.restfulwebservice.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;
import java.net.URI;
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
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = service.findOne(id);

        if (user == null) throw new UserNotFoundException(String.format("ID[%s] not found", id));

        // 접근제한자가 protected 로 되어있기 때문에 사용할 수 없다.
        // EntityModel<User> model = new EntityModel<>(user);
        EntityModel<User> model = EntityModel.of(user);

        model.add(linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users"));

        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User saveUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

}
