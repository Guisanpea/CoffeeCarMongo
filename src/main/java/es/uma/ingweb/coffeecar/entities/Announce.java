package es.uma.ingweb.coffeecar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Announce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private Date departureTime;
    private Date arrivalDate;
    private String description;
    private String arrival;
    private double arrivalLatitude;
    private double arrivalLongitude;
    private String departure;
    private double departureLatitude;
    private double getDepartureLongitude;
    private int seats;
    @ManyToOne(cascade = CascadeType.ALL)
    private User driver;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> passengers;
}
