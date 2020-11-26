package masterIL.gpsLab.client;

import masterIL.gpsLab.modele.*;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Client {

    public Client() {
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AbstractXmlApplicationContext context = new FileSystemXmlApplicationContext("configuration/appContext.xml");
        IGps g ;

        g = context.getBean(RandomGps.class);
        System.out.println("RandomGps : " + g.where()) ;

        g = context.getBean(RandomGpsMessage.class);
        g.where() ;
    }

    public static void main(String[] args) {
        new Client() ;
    }
}
