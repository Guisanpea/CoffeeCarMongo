package es.uma.ingweb.coffeecar.repositories;

import java.util.List;

import es.uma.ingweb.coffeecar.entities.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "anuncio", path = "anuncio")
public interface AnuncioRepository extends PagingAndSortingRepository<Anuncio, Long> {

    List<Anuncio> findAnunciosByFecha_entrada(@Param("fecha_entrada") String fecha_entrada);
    List<Anuncio> findAnuncioByFecha_salidaAndDestino(@Param("fecha_salida") String fecha_salida, @Param("destino") String destino);
    String findByTitulo(@Param("titulo") String titulo);

}