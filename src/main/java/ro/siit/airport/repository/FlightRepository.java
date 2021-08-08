package ro.siit.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.domain.Flight;
import ro.siit.airport.model.FlightDto;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {


    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, dep.name, arr.name, air.airlineName) " +
            "from Flight f inner join f.departureAirport dep inner join f.arrivalAirport arr inner join f.airline air " +
            "where dep.id = :departureAirportId and f.departure > current_date and f.departure < current_date+1 and f.departure > current_timestamp " +
            "order by f.departure "
    )
    List<FlightDto> findFlightsByDepartureAirport(@Param("departureAirportId") final Long departureAirportId);

    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, dep.name, arr.name, air.airlineName) " +
            "from Flight f inner join f.departureAirport dep inner join f.arrivalAirport arr inner join f.airline air " +
            "where dep.id = :departureAirportId and f.arrival > current_date and f.arrival < current_date+1 and f.arrival > current_timestamp " +
            "order by f.arrival "
    )
    List<FlightDto> findFlightsByArrivalAirport(@Param("departureAirportId") final Long departureAirportId);

    @Query("select f from Flight f where f.departureAirport=:fId and f.departure between :startData and :endData")
    List<Flight> retrieveDepartureFlightByAirport(@Param("fId") Airport id,
                                                  @Param("startData") LocalDateTime startData,
                                                  @Param("endData") LocalDateTime endData);


    @Query("select f from Flight f where f.arrivalAirport=:fId and f.arrival between :startData and :endData")
    List<Flight> retrieveArrivalFlightByAirport(@Param("fId") Airport id,
                                                @Param("startData") LocalDateTime startData,
                                                @Param("endData") LocalDateTime endData);

    @Query("select f from Flight f where f.airline=:fId and f.departure between :startData and :endData")
    List<Flight> retrieveDepartureFlightByAirline(@Param("fId") Airline id,
                                                  @Param("startData") LocalDateTime startData,
                                                  @Param("endData") LocalDateTime endData);

    @Query("select f from Flight f where f.airline=:fId and f.arrival between :startData and :endData")
    List<Flight> retrieveArrivalFlightByAirline(@Param("fId") Airline id,
                                                  @Param("startData") LocalDateTime startData,
                                                  @Param("endData") LocalDateTime endData);
}
