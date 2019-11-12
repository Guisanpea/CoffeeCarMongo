package es.uma.ingweb.coffeecar;


import es.uma.ingweb.coffeecar.entities.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeecarApplication {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.getAnuncioPropiedad();
        SpringApplication.run(CoffeecarApplication.class, args);
    }

}
