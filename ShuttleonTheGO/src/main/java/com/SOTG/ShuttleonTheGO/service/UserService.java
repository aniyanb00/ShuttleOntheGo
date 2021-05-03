package com.SOTG.ShuttleonTheGO.service;

import com.SOTG.ShuttleonTheGO.model.User;
import com.SOTG.ShuttleonTheGO.repo.UserRepo;
import com.SOTG.ShuttleonTheGO.view.LoginViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {


        this.userRepo = userRepo;
    }

    //Create User
    public User addUser(User user){

        User saveUser = new User();

        saveUser = userRepo.saveAndFlush(user);

        return saveUser;
    }

    //findUsername and Password
    public User findbyUsernameandPassword(LoginViewModel loginViewModel){

        User user = userRepo.findbyUsernameandPassword(loginViewModel.getUsername(), loginViewModel.getPassword()).orElseThrow(()->new IllegalArgumentException("Username and/or password incorrect"));

        return user;
    }


    //getUserbyID
    public Optional<User> findUserbyID(int id){
       Optional<User> user = userRepo.findById(id);

       if(!user.isPresent()){
           throw new IllegalArgumentException("User id is not found ");
       }

       return user;

    }

    //update account
    public User updateUser(User user){
       return userRepo.save(user);
    }

    //delete account
    public void deleteUser(int id){
        userRepo.deleteById(id);
    }

}
