package com.SOTG.ShuttleonTheGO.view;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class RequestViewModel {

    @NotEmpty
    private String stopName;

    private String ETA;


    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestViewModel that = (RequestViewModel) o;
        return Objects.equals(stopName, that.stopName) && Objects.equals(ETA, that.ETA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopName, ETA);
    }
}
