package com.SOTG.ShuttleonTheGO.controller;

import com.SOTG.ShuttleonTheGO.model.Stop;
import com.SOTG.ShuttleonTheGO.model.User;
import com.SOTG.ShuttleonTheGO.service.RequestService;
import com.SOTG.ShuttleonTheGO.service.UserService;
import com.SOTG.ShuttleonTheGO.view.RequestViewModel;

import com.SOTG.ShuttleonTheGO.view.UserViewModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

import java.util.List;


@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private DistanceTime distance;

    @Autowired
    RequestService requestService;

    private String time;


    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/sign_up")
    public String signUpForm(Model model){
        model.addAttribute("user",new UserViewModel());

        return "sign_up";
    }
    @GetMapping("/time")
    public String viewTime(Model model){
        String actualTime = getTime();
        model.addAttribute("time", actualTime);
        return "time";
    }

    @PostMapping(value = "/sign_up")
    public String createUser(@ModelAttribute("user") UserViewModel user) {
        if(user.getPassword().equals(user.getRepeatPassword())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            User newUser = userService.addUser(user);
        }
        else{
            throw new IllegalArgumentException("Passwords dont match");
        }

        return "success";
    }

    @RequestMapping("/requestPage")
    public String makeRequest(Model model){
        model.addAttribute("selectedRequest", new RequestViewModel());
        allStops();
        return "requestPage";
    }

    @ModelAttribute("requestList")
    public List<Stop> allStops(){
        List<Stop> stop = requestService.getAllStops();
        return stop;
    }

    @RequestMapping("/request")
    public String makeRequest(@ModelAttribute("selectedRequest") RequestViewModel selectedRequest){

        System.out.println(selectedRequest.getStopName());
        selectedRequest.setETA(requestApi(selectedRequest));

        System.out.println(selectedRequest.getETA());

        setTime(selectedRequest.getETA());

        return "time";
    }


    public String requestApi(@ModelAttribute("selectedRequest") RequestViewModel request){
        try{
            String response = distance.calculate(request);

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(response);
            JSONObject jsonobj=(JSONObject)obj;

            JSONArray dist=(JSONArray)jsonobj.get("rows");
            JSONObject obj2 = (JSONObject)dist.get(0);
            JSONArray disting =(JSONArray)obj2.get("elements");
            JSONObject obj3 = (JSONObject)disting.get(0);
            JSONObject obj5=(JSONObject)obj3.get("duration");


            String time = obj5.get("text").toString();
            return time;



        }catch (IllegalArgumentException | IOException | ParseException e){
            throw new IllegalArgumentException("Exception occured");
        }

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
