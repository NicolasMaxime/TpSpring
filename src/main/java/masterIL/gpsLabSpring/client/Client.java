package masterIL.gpsLabSpring.client;

import masterIL.gpsLab.modele.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@ComponentScan(basePackages = {"masterIL.gpsLab.modele"})
public class Client {

    public static void main(String[] args) {
        SpringApplication.run(Client.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            IGps g;
            g = ctx.getBean(RandomGps.class);
            System.out.println("RandomGps : " + g.where());

            g = ctx.getBean(RandomGpsMessage.class);
            g.where();

            g = ctx.getBean(GpsRandomSpace.class, ctx.getBean(Message.class, "message"), "string", 10);
            g.where();
        };
    }
}
