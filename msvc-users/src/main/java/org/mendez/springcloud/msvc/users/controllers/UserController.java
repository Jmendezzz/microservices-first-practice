package org.mendez.springcloud.msvc.users.controllers;


import org.mendez.springcloud.msvc.users.entities.User;
import org.mendez.springcloud.msvc.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getAll(){
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable Long id){
    Optional<User> userOptional = userService.getById(id); // CTRL + ALT + V

    return userOptional
            .map(u-> new ResponseEntity<>(u,HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<User> save(@RequestBody User user){
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<User> update(@RequestBody User user){
    Optional<User> userOptional = userService.getById(user.getId());
    return userOptional
            .map(u-> new ResponseEntity<>(userService.save(user), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    Optional<User> userOptional = userService.getById(id);

    if(userOptional.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    userService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
