package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.domain.Country;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByCountry(Country country);

    Optional<Airport> findAirportById(Long id);
}
