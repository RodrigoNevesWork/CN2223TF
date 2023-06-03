package utils;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private Float lat;
    private Float lng;


    public Coordinates(Float lat, Float lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public Coordinates(){}

    public Float getLatitude() {
        return lat;
    }

    public Float getLongitude() {
        return lng;
    }

    public void setLatitude(Float lat) {
        this.lat = lat;
    }

    public void setLongitude(Float lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
