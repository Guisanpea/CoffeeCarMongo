package es.uma.ingweb.coffeecar.repositories;

import es.uma.ingweb.coffeecar.entities.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Announce", path = "announced")
public interface AnnounceRepository extends PagingAndSortingRepository<Announce, Long> {

    List<Announce> findByDriver(@Param("driver") User driver);
    List<Announce> findByPassengers(@Param("pasengers") User passenger);
}
