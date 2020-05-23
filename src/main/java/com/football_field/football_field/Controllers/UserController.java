package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User User){
        return userService.save(User);
    }

    @CrossOrigin
    @PostMapping("/create")
    public Boolean create(@RequestBody User User){
        return userService.createUser(User);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }
}
