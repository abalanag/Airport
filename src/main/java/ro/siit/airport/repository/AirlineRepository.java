package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Country;
import ro.siit.airport.model.AirlineDto;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

    @Query("select new ro.siit.airport.model.AirlineDto(a.id, a.airlineName, a.country, a.iata, a.icao) " +
            "from Airline a where a.country =:cId")
    List<AirlineDto> findByCountry(@Param("cId") final Country country);
}
