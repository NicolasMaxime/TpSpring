package masterIL.gpsLab.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomGps implements IGps {

    @Autowired
    public RandomGps() {
    }

    public Coordonnees where() {
        return new Coordonnees() ;
    }
}
