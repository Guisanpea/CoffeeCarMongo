package es.uma.ingweb.coffeecar.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.uma.ingweb.coffeecar.entities.consumersAux.Fields;
import es.uma.ingweb.coffeecar.entities.consumersAux.Records;
import es.uma.ingweb.coffeecar.entities.consumersAux.Result;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusData {
    private int _id;
    private int codParada;
    private float codLinea;
    private float lat;
    private float lon;
    private Fields f;
    private Records r;
    private Result re;

    public BusData(){}

    public BusData(int _id, int codParada, float codLinea, float lat, float lon, Fields f, Records r, Result re) {
        this._id = _id;
        this.codParada = codParada;
        this.codLinea = codLinea;
        this.lat = lat;
        this.lon = lon;
        this.f = f;
        this.r = r;
        this.re = re;
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

    public Fields getF() {
        return f;
    }

    public void setF(Fields f) {
        this.f = f;
    }

    public Records getR() {
        return r;
    }

    public void setR(Records r) {
        this.r = r;
    }

    public Result getRe() {
        return re;
    }

    public void setRe(Result re) {
        this.re = re;
    }
}