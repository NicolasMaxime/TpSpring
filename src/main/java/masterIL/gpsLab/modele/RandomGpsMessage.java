package masterIL.gpsLab.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomGpsMessage implements IGps {

    private IMessage message ;

    @Autowired
    public RandomGpsMessage(IMessage message) {
        this.message = message;
    }

    public Coordonnees where() {
        Coordonnees w = new Coordonnees();
        message.post("RandomGpsMessage : " + w) ;
        return w ;
    }

}
