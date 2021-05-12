package com.SOTG.ShuttleonTheGO.controller;

import com.SOTG.ShuttleonTheGO.model.Stop;
import com.SOTG.ShuttleonTheGO.service.RequestService;
import com.SOTG.ShuttleonTheGO.view.RequestViewModel;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class DistanceTime {

    @Autowired
    private RequestService requestService;

    private static final String API_KEY= "removed key for security purpose";
    OkHttpClient client = new OkHttpClient();


    public String calculate(RequestViewModel viewModel) throws IOException {

        // get stop long lat
        Stop stopPoint = requestService.getStopLongLat(viewModel);

        double stopLong = stopPoint.getLongitude();
        double stopLat = stopPoint.getLatitude();

        //get driver long lat
        double driveLong = -76.255066;
        double driveLat = 36.846771;

        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+stopLat+","+stopLong+"&destinations="+driveLat+","+driveLong+"&key="+API_KEY;


        Request request = new Request.Builder()
            .url(url)
            .build();

            Response response = client.newCall(request).execute();


            return response.body().string();

    }
}
