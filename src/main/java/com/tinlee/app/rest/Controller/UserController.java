package com.tinlee.app.rest.Controller;

import com.tinlee.app.rest.Models.User;
import com.tinlee.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/api/v1/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping(value = "/")
    public String getPages(){
        return "pages";
    }

    @PostMapping(value = "/api/v1/users")
    public ResponseEntity saveUser(@RequestBody User user){
        userRepo.save(user);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/api/v1/user/{id}")
    public ResponseEntity updateUser(@PathVariable long id,@RequestBody User user){
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/api/v1/user/{id}")
    public String deleteUser(@PathVariable long id,@RequestBody User user){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "deleted......";
    }

    @RequestMapping(value = "/api/v1/user/{id}")
    public ResponseEntity< User > getOneUser(@PathVariable Long id) {
        User user = userRepo.findById(id).get();
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }
}
