package es.uma.ingweb.coffeecar;

import es.uma.ingweb.coffeecar.entities.BusData;
import es.uma.ingweb.coffeecar.entities.Person;
import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
@Log
public class CoffeecarApplication {

    public static void main(String[] args) {
        Person person = new Person();
        person.getFirstName();
        SpringApplication.run(CoffeecarApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            ResponseEntity<BusData> busData = restTemplate.getForEntity(
                    "http://datosabiertos.malaga.eu/api/3/action/d atastore_search?resource_id=d7eb3174-dcfb-4917-9876-c0e21dd810e3", BusData.class);

            assert busData != null;
            log.info(busData.toString());
        };
    }
}