package es.uma.ingweb.coffeecar.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusData {
    private int codParada;
    private float codLinea;
    private float lat;
    private float lon;

    public BusData(){}

    public BusData(int codParada, float codLinea, float lat, float lon) {
        this.codParada = codParada;
        this.codLinea = codLinea;
        this.lat = lat;
        this.lon = lon;
    }

    public int getCodParada() {
        return codParada;
    }

    public void setCodParada(int codParada) {
        this.codParada = codParada;
    }

    public float getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(float codLinea) {
        this.codLinea = codLinea;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "BusData{" +
                "codParada=" + codParada +
                ", codLinea=" + codLinea +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}