package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Servicies.UserService;
import com.football_field.football_field.side_models.LoginUserModel;
import com.football_field.football_field.side_models.SignUpUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/getByUserName")
    public ResponseEntity<SignUpUserModel> signUpUserModel(@RequestParam String userName){
        SignUpUserModel signUpUserModel = userService.getSignUpModel(userName);
        try {
            return new ResponseEntity<>(signUpUserModel,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User User){
        User user =  userService.createUser(User);
        try {
            if (user != null){
                 return new ResponseEntity<>(user,HttpStatus.ALREADY_REPORTED);
            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginUserModel loginUserModel){
        User user = userService.login(loginUserModel);
        try {
            if (user == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }
}
