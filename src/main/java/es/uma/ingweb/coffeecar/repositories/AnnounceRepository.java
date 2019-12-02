package es.uma.ingweb.coffeecar.repositories;

import es.uma.ingweb.coffeecar.entities.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Announce", path = "announced")
public interface AnnounceRepository extends PagingAndSortingRepository<Announce, Long> {

    List<Announce> findAnnouncesByDriver_Mail(@Param("mail") String mail);
    @Query(value = "Select a from Announce a, a.passengers where p.mail like concat('%',:mail,'%')", nativeQuery = true)
    List<Announce> findAnnouncesByPassengers(@Param("mail") String mail);
    @Query(value = "Select a from Announce a, a.passengers p where p.mail not like concat('%',:mail_passenger,'%') and a.driver.mail " +
            "not like concat('%',:driver_mail,'%')", nativeQuery = true)
    List<Announce> findAnnouncesByDriverNotAndPassengersNot(@Param("driver_mail") String driver_mail, @Param("mail_passenger") String mail_passenger);
    List<Announce> findAnnouncesByArrival(@Param("arrival")String arrival);
    List<Announce> findAnnouncesByArrivalAndArrivalDate(String arrival, LocalDateTime arrivalDate);
    List<Announce> findAnnouncesByArrivalDate(LocalDateTime arrivalDate);
}
