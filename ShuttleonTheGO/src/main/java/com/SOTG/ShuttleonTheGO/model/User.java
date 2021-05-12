package com.SOTG.ShuttleonTheGO.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User {

    //sign-in model
    //information that we need to sign in
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column( nullable = false)
    private String f_name;

    @Column(nullable = false)
    private String l_name;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(name = "driver_status",columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean driverStatus; //true for driver false for rider;

    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Set<Request> requestSet;

    public Set<Request> getRequestSet() {
        return requestSet;
    }

    public void setRequestSet(Set<Request> requestSet) {
        this.requestSet = requestSet;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id && driverStatus == user.driverStatus && Objects.equals(f_name, user.f_name) && Objects.equals(l_name, user.l_name) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(requestSet, user.requestSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, f_name, l_name, username, password, email, driverStatus, requestSet);
    }
}
