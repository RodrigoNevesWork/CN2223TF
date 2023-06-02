import java.io.Serializable;

public class AnaliseResult implements Serializable {
    private String description;
    private float certainty;
    private Coordinates coordinates;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCertainty() {
        return certainty;
    }

    public void setCertainty(float certainty) {
        this.certainty = certainty;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public AnaliseResult(String description, float certainty, Coordinates coordinates){
        this.description = description;
        this.certainty = certainty;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "AnaliseResult{" +
                "description='" + description + '\'' +
                ", certainty=" + certainty +
                ", coordinates=" + coordinates +
                '}';
    }
}
