package ro.siit.airport.service;

import ro.siit.airport.model.EditFlightDto;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.FlightRequestDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> findTodayDepartureFlights(Long airportId);
    List<FlightDto> findTodayArrivalFlights(Long airportId);
    List<FlightDto> findByAirport(FlightRequestDto flightRequestDto);
    List<FlightDto> findByAirline(FlightRequestDto FlightRequestDto);
    Boolean saveRecord(FlightDto FlightDto);
    EditFlightDto findById(final Long Id);
    List<FlightDto> findAllFlights();
    Boolean updateFlight(final EditFlightDto editFlightDto);
    boolean deleteRecord(Long id);
}
