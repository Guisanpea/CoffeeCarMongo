package es.uma.ingweb.coffeecar;

import es.uma.ingweb.coffeecar.entities.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeecarApplication {
    public static void main(String[] args) {
        Person person = new Person();
        person.getFirstName();
        SpringApplication.run(CoffeecarApplication.class, args);
    }

}
