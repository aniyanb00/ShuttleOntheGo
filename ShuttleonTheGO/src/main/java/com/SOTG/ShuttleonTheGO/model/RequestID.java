package com.SOTG.ShuttleonTheGO.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RequestID implements Serializable {

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "stop_id")
    private int stop_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStop_id() {
        return stop_id;
    }

    public void setStop_id(int stop_id) {
        this.stop_id = stop_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestID requestID = (RequestID) o;
        return user_id == requestID.user_id && stop_id == requestID.stop_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, stop_id);
    }
}
