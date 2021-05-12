package com.SOTG.ShuttleonTheGO.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "request")
public class Request {

    @EmbeddedId
    private RequestID id;

    //user
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    //stop
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stop_id")
    @JoinColumn(name = "stop_id", insertable = false, updatable = false)
    private Stop stops;

    @Column(name = "accepted",columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean accepted;


    public RequestID getId() {
        return id;
    }

    public void setId(RequestID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stop getStops() {
        return stops;
    }

    public void setStops(Stop stops) {
        this.stops = stops;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return accepted == request.accepted && Objects.equals(id, request.id) && Objects.equals(user, request.user) && Objects.equals(stops, request.stops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, stops, accepted);
    }

}
