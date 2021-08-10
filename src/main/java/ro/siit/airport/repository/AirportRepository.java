package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.domain.Country;
import ro.siit.airport.model.AirportDto;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("select new ro.siit.airport.model.AirportDto(a.id, a.name, a.city, a.latitude, a.longitude, active) " +
            "from Airport a where a.country =:cId")
    List<AirportDto> findByCountry(@Param("cId") final Country country);

    @Query("select new ro.siit.airport.model.AirportDto(a.id, a.name, a.city, a.latitude, a.longitude, active) " +
            "from Airport a where a.id =:aId")
    Optional<AirportDto> findAirportById(@Param("aId") final Long id);
}
