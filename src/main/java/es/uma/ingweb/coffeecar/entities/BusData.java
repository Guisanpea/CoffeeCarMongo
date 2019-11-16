package es.uma.ingweb.coffeecar.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusData {
    private int _id;
    private int codParada;
    private float codLinea;
    private float lat;
    private float lon;

    public BusData(){}

    public BusData(int _id, int codParada, float codLinea, float lat, float lon) {
        this._id = _id;
        this.codParada = codParada;
        this.codLinea = codLinea;
        this.lat = lat;
        this.lon = lon;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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
}