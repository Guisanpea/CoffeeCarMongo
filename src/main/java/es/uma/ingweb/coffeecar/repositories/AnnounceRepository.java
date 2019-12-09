package es.uma.ingweb.coffeecar.repositories;

import es.uma.ingweb.coffeecar.entities.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "announces", path = "announces")
public interface AnnounceRepository extends CrudRepository<Announce, Long> {

    List<Announce> findAnnouncesByArrival(@Param("arrival")String arrival);
    List<Announce> findAnnouncesByArrivalAndArrivalDate(@Param("arrival") String arrival, @Param("arrival") String arrivalDate);
    List<Announce> findAnnouncesByArrivalDate(@Param("arrivalDate") String arrivalDate);
    List<Announce> findAnnouncesByDriverEmail(@Param("email") String driverEmail);
    List<Announce> findAnnouncesByDriverEmailNot(@Param("email") String driverEmail);
    @Query("select a from Announce a left join a.passengers u where u.email = ?1")
    List<Announce> findByPassengersEmails(String email);
    @Query("SELECT DISTINCT a from Announce a JOIN a.driver d " +
          "WHERE d.email <> ?1 and ?1 NOT IN (SELECT p.email from a.passengers p)")
    List<Announce> findAvailableAnnounces(String email);
    @Query("select distinct a from Announce a " +
          "left join a.passengers p left join a.driver d " +
          "where p.email <> ?1 and d.email <> ?1")
    List<Announce> findUserTrips(String email);
}
