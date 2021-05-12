package com.SOTG.ShuttleonTheGO.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@NaturalIdCache
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stop_id;

    @Column(name = "stop_name")
    @NaturalId
    private String stop_name;

    @Column(name = "latitude",precision = 10, scale =8)
    private double latitude;

    @Column(name = "longitude", precision = 10, scale =8)
    private double longitude;

    public int getStop_id() {
        return stop_id;
    }

    public void setStop_id(int stop_id) {
        this.stop_id = stop_id;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return stop_id == stop.stop_id && Double.compare(stop.latitude, latitude) == 0 && Double.compare(stop.longitude, longitude) == 0 && Objects.equals(stop_name, stop.stop_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stop_id, stop_name, latitude, longitude);
    }
}
