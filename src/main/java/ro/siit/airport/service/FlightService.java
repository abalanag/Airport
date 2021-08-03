package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.FlightRequestDto;

import java.util.List;


public interface FlightService {

    List<FlightDto> findByAirport(FlightRequestDto flightRequestDto);

}
