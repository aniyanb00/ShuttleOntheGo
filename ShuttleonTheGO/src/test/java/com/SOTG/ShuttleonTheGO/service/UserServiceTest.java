package com.SOTG.ShuttleonTheGO.service;

import com.SOTG.ShuttleonTheGO.model.User;
import com.SOTG.ShuttleonTheGO.repo.UserRepo;
import com.SOTG.ShuttleonTheGO.view.UserViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class UserServiceTest {

    UserService  userService;
    UserRepo userRepo;

    @Before
    public void setUp() throws Exception{

        setUpUserRepoMock();

        userService = new UserService(userRepo);
    }

    @Test
    public void shouldSaveUser(){
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setUsername("niya1234");
        userViewModel.setPassword("hello");
        userViewModel.setRepeatPassword("hello");
        userViewModel.setFirstName("Aniya");
        userViewModel.setLastName("Brown");
        userViewModel.setEmail("niya1234@gmail.com");
        userViewModel.setIsDriverStatus("Driver");

       User user = userService.addUser(userViewModel);

       User saveUser = userService.findUser(user.getUsername());

       assertEquals(user,saveUser);


    }
    private void setUpUserRepoMock(){
        userRepo = mock(UserRepo.class);

        User user = new User();
        user.setUser_id(2);
        user.setUsername("niya1234");
        user.setPassword("hello");
        user.setF_name("Aniya");
        user.setL_name("Brown");
        user.setEmail("niya1234@gmail.com");
        user.setDriverStatus(true);

        User user1 = new User();
        user1.setUsername("niya1234");
        user1.setPassword("hello");
        user1.setF_name("Aniya");
        user1.setL_name("Brown");
        user1.setEmail("niya1234@gmail.com");
        user1.setDriverStatus(true);

        doReturn(user).when(userRepo).saveAndFlush(user1);
        doReturn(user).when(userRepo).findbyUsername(user.getUsername());
    }

}