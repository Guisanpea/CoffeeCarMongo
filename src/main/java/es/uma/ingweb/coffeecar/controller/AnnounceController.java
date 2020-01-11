package es.uma.ingweb.coffeecar.controller;

import es.uma.ingweb.coffeecar.entities.Announce;
import es.uma.ingweb.coffeecar.repositories.AnnounceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announces")
public class AnnounceController {

    private final AnnounceRepository announceRepository;

    public AnnounceController(AnnounceRepository announceRepository) {
        this.announceRepository = announceRepository;
    }

    @GetMapping
    public List<Announce> findAll() {
        return announceRepository.findAll();
    }

    @PostMapping
    public Announce create(@RequestBody Announce announce) {
        return announceRepository.save(announce);
    }

    @GetMapping("/search/findByArrival")
    public List<Announce> findAnnouncesByArrival(String arrival) {
        return announceRepository.findAnnouncesByArrival(arrival);
    }

    @GetMapping("/search/findByDriverEmail")
    List<Announce> findAnnouncesByDriverEmail(String driverEmail) {
        return announceRepository.findAnnouncesByDriverEmail(driverEmail);
    }

    @GetMapping("/search/findByDriverEmailNot")
    List<Announce> findAnnouncesByDriverEmailNot(String driverEmail) {
        return announceRepository.findAnnouncesByDriverEmailNot(driverEmail);
    }
}
