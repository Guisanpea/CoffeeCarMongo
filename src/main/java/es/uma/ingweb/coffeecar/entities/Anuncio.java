package es.uma.ingweb.coffeecar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private Date fecha_salida;
    private Date fecha_entrada;
    private String descripcion;
    private String destino;
    private String salida;
    private int plazas;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="creador")
    private Usuario creador;
    @ManyToMany(mappedBy="anunciosUnidos", cascade = CascadeType.ALL)
    private List<Usuario> usuariosUnidos;
}
