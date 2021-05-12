package com.SOTG.ShuttleonTheGO.service;

import com.SOTG.ShuttleonTheGO.model.User;
import com.SOTG.ShuttleonTheGO.repo.UserRepo;
import com.SOTG.ShuttleonTheGO.view.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //Create User
    @Transactional
    public User addUser(UserViewModel user){

        User saveUser = new User();
        saveUser.setF_name(user.getFirstName());
        saveUser.setL_name(user.getLastName());
        saveUser.setUsername(user.getUsername());
        saveUser.setPassword(user.getPassword());
        saveUser.setEmail(user.getEmail());

        if(user.getIsDriverStatus().equalsIgnoreCase("Driver")){
            saveUser.setDriverStatus(true);
        }
        else{
            saveUser.setDriverStatus(false);
        }

        return userRepo.saveAndFlush(saveUser);
    }

    public User findUser(String username){
       return userRepo.findbyUsername(username);

    }

}
