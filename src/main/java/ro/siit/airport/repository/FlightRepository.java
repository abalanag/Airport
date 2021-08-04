package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.domain.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select f from Flight f where f.departureAirport=:fId and f.departure between :startData and :endData")
    List<Flight> retrieveDepartureFlightByAirport(@Param("fId") Airport id,
                                                  @Param("startData") LocalDateTime startData,
                                                  @Param("endData") LocalDateTime endData);

    @Query("select f from Flight f where f.arrivalAirport=:fId and f.arrival between :startData and :endData")
    List<Flight> retrieveArrivalFlightByAirport(@Param("fId") Airport id,
                                                @Param("startData") LocalDateTime startData,
                                                @Param("endData") LocalDateTime endData);
}
