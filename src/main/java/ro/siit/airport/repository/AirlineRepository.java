package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Country;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

    List<Airline> findByCountry(Country country);

    Optional<Airline> findAirlineById(Long id);

}
