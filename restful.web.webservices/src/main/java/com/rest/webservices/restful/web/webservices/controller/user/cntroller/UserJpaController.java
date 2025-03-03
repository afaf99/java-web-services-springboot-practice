package com.rest.webservices.restful.web.webservices.controller.user.cntroller;

import com.rest.webservices.restful.web.webservices.jpa.UserRepository;
import com.rest.webservices.restful.web.webservices.user.module.Post;
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
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {


    @Autowired
    private UserRepository repository;

    private UserDaoService userDaoService;

    public UserJpaController(UserDaoService userDaoService, UserRepository repository){
        this.userDaoService =userDaoService;
        this.repository= repository;
    }


    @GetMapping("/jpa/users")
    public List<User> getAllUsers(){

        return repository.findAll();
    }



    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id: "+ id);
        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);

    }

    @GetMapping("/jpa/users/{id}/post")
    public List<Post> retrievePostForUser(@PathVariable int id){
            Optional<User> user = repository.findById(id);
            if (user.isEmpty())
                throw new UserNotFoundException("id: "+ id);
            return user.get().getPost();
        }
}
