package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.airport.domain.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
