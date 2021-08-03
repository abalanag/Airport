package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.airport.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
