package es.uma.ingweb.coffeecar.controller;


import es.uma.ingweb.coffeecar.entities.StopHierarchy;
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
@RequestMapping("/getStops")
public class StopConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/all")
    public List<StopHierarchy.StopInfoResponse.StopData> getBus(){
        String uri = "http://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=d7eb3174-dcfb-4917-9876-c0e21dd810e3";
        List<StopHierarchy.StopInfoResponse.StopData> stops =
                restTemplate.getForObject(uri, StopHierarchy.class).getResult().getStopsData();

        return stops;
    }

    @GetMapping(value="/by")
    public List<StopHierarchy.StopInfoResponse.StopData> getBusByPosition(@RequestParam(name="lat", required=true) float lat,
                                                                         @RequestParam(name="lon", required=true) float lon){
        String uri = "http://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=d7eb3174-dcfb-4917-9876-c0e21dd810e3";
        List<StopHierarchy.StopInfoResponse.StopData> stops =
                restTemplate.getForObject(uri, StopHierarchy.class).getResult().getStopsData();
        GeographicalCoordinates current = new GeographicalCoordinates(lat, lon);
        List<StopHierarchy.StopInfoResponse.StopData> nearbyBuses = new ArrayList<>();
        stops.forEach(b-> {
            if(current.distanceTo(new GeographicalCoordinates(b.getLat(), b.getLon()))<=1.5) nearbyBuses.add(b);
        });

        return nearbyBuses.size()>0 ? nearbyBuses: stops;
    }
}
