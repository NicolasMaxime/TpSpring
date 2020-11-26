package masterIL.gpsLab.configuration;

import masterIL.gpsLab.modele.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public IMessage message(){ return new Message(); }

    @Bean
    public IGps randomGps() { return new RandomGps(); }

    @Bean
    public IGps randomGpsMessage(){ return new RandomGpsMessage(message()); }

}
