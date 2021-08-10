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


    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, f.departureAirport, f.arrivalAirport, f.airline) " +
            "from Flight f " +
            "where f.arrivalAirport = :fId and f.departure > current_date and f.departure < current_date+1 and f.departure > current_timestamp " +
            "order by f.departure "
    )
    List<FlightDto> findFlightsByDepartureAirport(@Param("fId") final Airport id);

    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, f.departureAirport, f.arrivalAirport, f.airline) " +
            "from Flight f " +
            "where f.departureAirport = :fId and f.arrival > current_date and f.arrival < current_date+1 and f.arrival > current_timestamp " +
            "order by f.arrival "
    )
    List<FlightDto> findFlightsByArrivalAirport(@Param("fId") final Airport id);

    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, f.departureAirport, f.arrivalAirport, f.airline) " +
            "from Flight f where f.departureAirport=:fId and f.departure between :startData and :endData order by f.departure ")
    List<FlightDto> retrieveDepartureFlightByAirport(@Param("fId") Airport id,
                                                     @Param("startData") LocalDateTime startData,
                                                     @Param("endData") LocalDateTime endData);


    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, f.departureAirport, f.arrivalAirport, f.airline) " +
            "from Flight f where f.arrivalAirport=:fId and f.arrival between :startData and :endData order by f.arrival ")
    List<FlightDto> retrieveArrivalFlightByAirport(@Param("fId") Airport id,
                                                   @Param("startData") LocalDateTime startData,
                                                   @Param("endData") LocalDateTime endData);

    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, f.departureAirport, f.arrivalAirport, f.airline) " +
            "from Flight f where f.airline=:fId and f.departure between :startData and :endData")
    List<FlightDto> retrieveDepartureFlightByAirline(@Param("fId") Airline id,
                                                     @Param("startData") LocalDateTime startData,
                                                     @Param("endData") LocalDateTime endData);

    @Query("select new ro.siit.airport.model.FlightDto(f.id, f.flightNumber, f.departure, f.arrival, f.departureAirport, f.arrivalAirport, f.airline) " +
            "from Flight f where f.airline=:fId and f.arrival between :startData and :endData")
    List<FlightDto> retrieveArrivalFlightByAirline(@Param("fId") Airline id,
                                                   @Param("startData") LocalDateTime startData,
                                                   @Param("endData") LocalDateTime endData);
}
