package es.uma.ingweb.coffeecar.controller;


import es.uma.ingweb.coffeecar.entities.BusData;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@ComponentScan("package es.uma.ingweb.coffeecar")
@RestController
public class BusConsumer {
    RestTemplate restTemp;

    @GetMapping(value="/getBus")
    public float getBus(){
        String uri = "http://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=d7eb3174-dcfb-4917-9876-c0e21dd810e3";

        ResponseEntity<BusData> responseEntity = restTemp.exchange(uri, HttpMethod.GET, null, BusData.class);

        return responseEntity.getBody().getCodLinea();
    }
}
