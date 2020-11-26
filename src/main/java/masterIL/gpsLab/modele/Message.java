package masterIL.gpsLab.modele;


import org.springframework.stereotype.Component;

@Component
public class Message implements IMessage {

    @Override
    public void post(String s) {
        System.out.println(s);
    }

}
