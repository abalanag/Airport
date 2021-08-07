package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;
import java.util.List;
import ro.siit.airport.model.FlightRequestDto;
import ro.siit.airport.model.AirlineFlightRequestDto;
import ro.siit.airport.model.EditFlightDto;

public interface FlightService {

    List<FlightDto> findTodayDepartureFlights(Long airportId);
    List<FlightDto> findTodayArrivalFlights(Long airportId);
    List<FlightDto> findByAirport(FlightRequestDto flightRequestDto);
    List<FlightDto> findByAirline(AirlineFlightRequestDto airlineFlightRequestDto);
    Boolean saveRecord(FlightDto FlightDto);
    EditFlightDto findById(final Long Id);
    List<FlightDto> findAllFlights();
    Boolean updateFlight(final EditFlightDto editFlightDto);
    boolean deleteRecord(Long id);
}
