package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select f from Flight f where f.airline=:fId and f.departure between :startData and :endData")
    List<Flight> retrieveDepartureFlightByAirline(@Param("fId") Airline id,
                                                  @Param("startData") LocalDateTime startData,
                                                  @Param("endData") LocalDateTime endData);

}
