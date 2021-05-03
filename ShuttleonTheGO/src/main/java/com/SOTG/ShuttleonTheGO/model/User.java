package com.SOTG.ShuttleonTheGO.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements Serializable {

    //sign-in model
    //information that we need to sign in
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(name= "f_name", nullable = false)
    private String f_name;

    @Column(name="l_name",nullable = false)
    private String l_name;

    @Column(name="username",nullable = false,unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name = "driver_status",columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean driverStatus; //true for driver false for rider;

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
        return getUser_id() == user.getUser_id() && isDriverStatus() == user.isDriverStatus() && Objects.equals(getF_name(), user.getF_name()) && Objects.equals(getL_name(), user.getL_name()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getF_name(), getL_name(), getUsername(), getPassword(), getEmail(), isDriverStatus());
    }
}
