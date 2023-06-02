import java.io.Serializable;

public class Coordinates implements Serializable {
    private Double lat;
    private Double lng;


    public Coordinates(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLatitude() {
        return lat;
    }

    public Double getLongitude() {
        return lng;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
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
