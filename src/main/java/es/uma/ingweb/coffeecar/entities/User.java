package es.uma.ingweb.coffeecar.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private List<Announce> ownedAnnounces;
    @ManyToMany(mappedBy = "passengers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private List<Announce> joinedAnnounces;
}