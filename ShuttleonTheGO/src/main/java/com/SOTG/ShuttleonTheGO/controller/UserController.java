package com.SOTG.ShuttleonTheGO.controller;

import com.SOTG.ShuttleonTheGO.model.User;
import com.SOTG.ShuttleonTheGO.service.UserService;
import com.SOTG.ShuttleonTheGO.view.LoginViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    //Get user login - get the username and password
    @GetMapping(value = "/login")
    public ResponseEntity getUserbyUserNamePassword(@RequestBody LoginViewModel login){


        User user = userService.findbyUsernameandPassword(login);

        if(user == null){
            throw new IllegalArgumentException("Username and/or Password Incorrect");
        }

        return new ResponseEntity("Login successfully", HttpStatus.OK);

    }

    //create user
    @PostMapping(value = "/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        try{
            User newUser = userService.addUser(user);
            return new ResponseEntity<User>(newUser,HttpStatus.CREATED);

        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Username is already used");
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getUserbyId(@PathVariable int id){
        Optional<User> user = userService.findUserbyID(id);

        return new ResponseEntity(user, HttpStatus.OK);
    }

}
