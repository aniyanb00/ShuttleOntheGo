package com.SOTG.ShuttleonTheGO.service;

import com.SOTG.ShuttleonTheGO.model.Request;
import com.SOTG.ShuttleonTheGO.model.Stop;
import com.SOTG.ShuttleonTheGO.model.User;
import com.SOTG.ShuttleonTheGO.repo.RequestRepo;
import com.SOTG.ShuttleonTheGO.repo.StopRepo;
import com.SOTG.ShuttleonTheGO.repo.UserRepo;
import com.SOTG.ShuttleonTheGO.view.LoginViewModel;
import com.SOTG.ShuttleonTheGO.view.RequestViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.*;

import java.util.Collection;
import java.util.List;

@Service
public class RequestService {

    private final StopRepo stopRepo;
    private final UserRepo userRepo;
    private final RequestRepo requestRepo;

    @Autowired
    public RequestService(StopRepo stopRepo, RequestRepo requestRepo, UserRepo userRepo) {
        this.stopRepo = stopRepo;
        this.requestRepo = requestRepo;
        this.userRepo = userRepo;
    }

    //save and make the Request
    public Request saveRequest(RequestViewModel viewModel){

        Request saveRequest = new Request();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();



        saveRequest.setUser(userRepo.findbyUsername(currentPrincipalName));
        saveRequest.setStops(stopRepo.getByStop_name(viewModel.getStopName()));
        saveRequest.setAccepted(true);

        return saveRequest;
    }
    public List<Stop> getAllStops(){
        return stopRepo.findAll();
    }
    //in order to save we need the point
    public Stop getStopLongLat(RequestViewModel viewModel){

        Stop reqStop = stopRepo.getByStop_name(viewModel.getStopName());

        return reqStop;
    }

    //then we need drivers location
    public Point setDriverlocation(){

        User driver = userRepo.findById(8).orElseThrow(()-> new IllegalArgumentException("Driver unavailable"));
        Point driverPoint = new Point();

        driverPoint.setLocation(36.846834,-76.255067);

        return driverPoint;
    }




}
