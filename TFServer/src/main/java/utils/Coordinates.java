package utils;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private Double lat;
    private Double lng;


    public Coordinates(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public Coordinates(){}

    public Double getLatitude() {
        return lat;
    }

    public Double getLongitude() {
        return lng;
    }

    public void setLatitude(Double lat) {
        this.lat = lat;
    }

    public void setLongitude(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Coordenates{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
