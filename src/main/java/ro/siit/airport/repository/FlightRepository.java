package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.airport.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
