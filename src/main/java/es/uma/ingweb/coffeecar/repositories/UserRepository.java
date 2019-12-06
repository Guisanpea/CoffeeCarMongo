package es.uma.ingweb.coffeecar.repositories;

import java.util.List;

import es.uma.ingweb.coffeecar.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findUserByEmail(@Param("email") String email);
    List<User> findUsersByName(@Param("name") String name);
}