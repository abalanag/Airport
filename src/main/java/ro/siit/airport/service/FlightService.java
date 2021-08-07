package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;
import java.util.List;
import ro.siit.airport.model.FlightRequestDto;

public interface FlightService {

    List<FlightDto> findTodayDepartureFlights(Long airportId);

    List<FlightDto> findTodayArrivalFlights(Long airportId);

    List<FlightDto> findByAirport(FlightRequestDto flightRequestDto);

