package ro.siit.airport.service;

import ro.siit.airport.model.EditFlightDto;
import ro.siit.airport.model.FlightDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> findTodayDepartureFlights(final Long airportId);

    List<FlightDto> findTodayArrivalFlights(final Long airportId);

    EditFlightDto findById(final Long Id);

    List<FlightDto> findAllFlights();

    Boolean updateFlight(final EditFlightDto editFlightDto);

}
