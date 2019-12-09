package es.uma.ingweb.coffeecar.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DataJpaTest
class AnnounceRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnnounceRepository announceRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void findAnnouncesByDriverEmail() {
        //when

    }

    @Test
    void findAnnouncesByDriverEmailNot() {
    }

    @Test
    void findByPassengersEmails() {
    }

    @Test
    void findAvailableAnnounces() {
    }

    @Test
    void findUserTrips() {
    }
}