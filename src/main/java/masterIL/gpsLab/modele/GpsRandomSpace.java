package masterIL.gpsLab.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GpsRandomSpace implements IGps {

    private IMessage m;
    private int v;
    private String s;

    @Autowired
    public GpsRandomSpace(IMessage m, String s, int v){
        this.v = v;
        this.m = m;
        this.s = s;
    }

    @Override
    public Coordonnees where() {
        Coordonnees w = new Coordonnees();
        m.post("GpsRandomSpace : "+ s + " " + v + " " + w) ;
        return w ;
    }
}
