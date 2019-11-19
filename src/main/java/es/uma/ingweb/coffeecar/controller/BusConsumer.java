package es.uma.ingweb.coffeecar.controller;


import es.uma.ingweb.coffeecar.entities.BusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class BusConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/getbus")
    public List<Object> getBus(){
        String uri = "http://datosabiertos.malaga.eu/api/3/action/datastore_search?resource_id=d7eb3174-dcfb-4917-9876-c0e21dd810e3";
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        BusData[] buses = restTemplate.getForObject(uri, BusData[].class);
        return Arrays.asList(buses);
    }
}
