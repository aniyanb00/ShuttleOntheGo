package com.SOTG.ShuttleonTheGO.service;

import com.SOTG.ShuttleonTheGO.model.User;
import com.SOTG.ShuttleonTheGO.repo.UserRepo;
import com.SOTG.ShuttleonTheGO.view.LoginViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findbyUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new LoginViewModel(user);
    }
}

