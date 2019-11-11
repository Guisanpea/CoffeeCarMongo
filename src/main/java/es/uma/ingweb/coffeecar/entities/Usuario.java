package es.uma.ingweb.coffeecar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name="contrasena")
    private String contrasena;
    @OneToMany(mappedBy = "creador")
    private List<Anuncio> anuncioPropiedad;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_anuncio",
            joinColumns = @JoinColumn(name = "anuncio_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id",
                    referencedColumnName = "id"))
    private List<Anuncio> anuncios;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Anuncio> getAnuncioPropiedad() {
        return anuncioPropiedad;
    }

    public void setAnuncioPropiedad(List<Anuncio> anuncioPropiedad) {
        this.anuncioPropiedad = anuncioPropiedad;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
}