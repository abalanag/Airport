package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.FlightRequestDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> findTodayDepartureFlights(Long airportId);
    List<FlightDto> findTodayArrivalFlights(Long airportId);
    List<FlightDto> findByAirport(FlightRequestDto flightRequestDto);
    List<FlightDto> findByAirline(FlightRequestDto FlightRequestDto);
    Boolean saveRecord(FlightDto FlightDto);
    FlightDto findById(final Long Id);
    List<FlightDto> findAllFlights();
    Boolean updateFlight(final FlightDto flightDto);
    boolean deleteRecord(Long id);
}
