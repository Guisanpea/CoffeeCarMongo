package es.uma.ingweb.coffeecar.repositories;

import java.util.List;

import es.uma.ingweb.coffeecar.entities.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usuario", path = "Usuario")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

    List<Usuario> findByCorreoAndNombre(@Param("correo") String correo, @Param("nombre") String nombre);
    List<Usuario> findUsuariosByAnuncioPropiedad(@Param("usuario") Usuario usuario);
}