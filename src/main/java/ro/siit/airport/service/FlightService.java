package ro.siit.airport.service;


import ro.siit.airport.model.AirlineFlightRequestDto;
import ro.siit.airport.model.FlightDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> findByAirline(AirlineFlightRequestDto airlineFlightRequestDto);

}
