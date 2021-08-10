package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.FlightRequestDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> findTodayDepartureFlights(final Long airportId);
    List<FlightDto> findTodayArrivalFlights(final Long airportId);
    List<FlightDto> findByAirport(final FlightRequestDto flightRequestDto);
    List<FlightDto> findByAirline(final FlightRequestDto FlightRequestDto);
    FlightDto findById(final Long Id);
    List<FlightDto> findAllFlights();
    Boolean saveRecord(final FlightDto FlightDto);
    Boolean updateFlight(final FlightDto flightDto);
    Boolean deleteRecord(final Long id);
}
