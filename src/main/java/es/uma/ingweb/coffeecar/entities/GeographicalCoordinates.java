package es.uma.ingweb.coffeecar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeographicalCoordinates {
    private float lon;
    private float lat;

    public float distanceTo(GeographicalCoordinates a2){
        //double radioTierra = 3958.75;//en millas
        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(a2.lat - lat);
        double dLng = Math.toRadians(a2.lon - lon);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(a2.lat));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return (float)distancia;
    }
}
