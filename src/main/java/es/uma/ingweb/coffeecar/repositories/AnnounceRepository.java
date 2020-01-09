package es.uma.ingweb.coffeecar.repositories;

import es.uma.ingweb.coffeecar.entities.Announce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnounceRepository extends MongoRepository<Announce, String> {
    List<Announce> findAnnouncesByArrival(String arrival);
    List<Announce> findAnnouncesByDriverEmail(String driverEmail);
    List<Announce> findAnnouncesByDriverEmailNot(String driverEmail);
}
