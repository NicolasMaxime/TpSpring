package masterIL.gpsLab.modele;

import java.util.Random;

public class Coordonnees {

    private double latitude ;
    private double longitude ;

    public Coordonnees() {
        this.latitude = (new Random().nextInt(180 + 1) ) - 89 ;
        this.longitude = (new Random().nextInt(360 + 1) ) - 180 ;
    }

    public Coordonnees(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
    public String toString() {
        return "Coordonnees{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }


}
