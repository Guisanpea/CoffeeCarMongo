package es.uma.ingweb.coffeecar.controller;

import es.uma.ingweb.coffeecar.entities.BusHierarchy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/getBuses")
public class BusConsumer {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/all")
    public List<BusHierarchy.BusInfoResponse.BusData> getBusesPosition(){
        String uri = "http://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=9bc05288-1c11-4eec-8792-d74b679c8fcf";
        List<BusHierarchy.BusInfoResponse.BusData> buses =
                restTemplate.getForObject(uri, BusHierarchy.class).getResult().getBusesData();

        return buses;
    }

    @GetMapping(value="/byLine")
    public List<BusHierarchy.BusInfoResponse.BusData> getBusesPosition(@RequestParam(name="line", required= true) float line){
        String uri = "https://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=9bc05288-1c11-4eec-8792-d74b679c8fcf";
        List<BusHierarchy.BusInfoResponse.BusData> buses =
                restTemplate.getForObject(uri, BusHierarchy.class).getResult().getBusesData();

        List<BusHierarchy.BusInfoResponse.BusData> selection = new ArrayList<>();
        buses.forEach(x -> {
            if(x.getCodLinea()==line) selection.add(x);
        });
        return selection.size()>0 ? selection : buses;
    }


}
