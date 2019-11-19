package es.uma.ingweb.coffeecar.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String contrasena;
    private String correo;
    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Anuncio> anuncioPropiedad;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_anuncio",
            joinColumns = @JoinColumn(name = "anuncio_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id",
                    referencedColumnName = "id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Anuncio> anunciosUnidos;
}