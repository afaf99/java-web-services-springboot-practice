package com.rest.webservices.restful.web.webservices.controller.user.cntroller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.rest.webservices.restful.web.webservices.user.module.User;
import com.rest.webservices.restful.web.webservices.user.module.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserDaoService userDaoService;
    public UserController(){
        this.userDaoService =userDaoService;
    }


    @GetMapping("/users")
    public List<User> getAllUsers(){

        return userDaoService.findAll();
    }



    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user = userDaoService.findById(id);
        if (user==null)
            throw new UserNotFoundException("id: "+ id);
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteById(id);

    }
}
