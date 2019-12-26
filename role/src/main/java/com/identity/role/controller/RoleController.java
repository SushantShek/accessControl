package com.identity.role.controller;

import com.identity.role.bean.User;
import com.identity.role.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/")
public class RoleController {

    @Autowired
   private AccessService service;
    @Autowired
    private User user;

    @GetMapping(path="roles/{id}", produces = "application/json")
    public User getRoles(@PathVariable long id)
    {
        return service.getAllAccess(id);
    }

    @PostMapping(path= "roles/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addRole(@Valid User user)
    {
        this.user =user;
        Long id = Long.valueOf(service.getAllAccess().length + 1);
        user.setId(id);

        service.addUserAccess(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Object> updateRole(@RequestBody User user, @PathVariable long id) {

         User usr = service.editUserAccess(user);
        usr.setId(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable long id) {
        service.deleteUserAccess(id);
    }
}
