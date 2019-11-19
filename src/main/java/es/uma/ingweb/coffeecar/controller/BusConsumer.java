package es.uma.ingweb.coffeecar.controller;


import es.uma.ingweb.coffeecar.entities.BusHierarchy;
import es.uma.ingweb.coffeecar.entities.GeographicalCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/getBus")
public class BusConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/all")
    public List<BusHierarchy.BusInfoResponse.BusData> getBus(){
        String uri = "http://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=d7eb3174-dcfb-4917-9876-c0e21dd810e3";
        List<BusHierarchy.BusInfoResponse.BusData> buses = restTemplate.getForObject(uri, BusHierarchy.class).getResult().getBusDatas();

        return buses;
    }

    @GetMapping(value="/by")
    public List<BusHierarchy.BusInfoResponse.BusData> getBusByPosition(@RequestParam(name="lat", required=true) float lat,
                                         @RequestParam(name="lon", required=true) float lon){
        String uri = "http://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=d7eb3174-dcfb-4917-9876-c0e21dd810e3";
        List<BusHierarchy.BusInfoResponse.BusData> buses = restTemplate.getForObject(uri, BusHierarchy.class).getResult().getBusDatas();
        GeographicalCoordinates current = new GeographicalCoordinates(lat, lon);
        List<BusHierarchy.BusInfoResponse.BusData> nearbyBuses = new ArrayList<>();
        buses.forEach(b-> {
            if(current.distanceTo(new GeographicalCoordinates(b.getLat(), b.getLon()))<=1.5) nearbyBuses.add(b);
        });

        return nearbyBuses;
    }
}
