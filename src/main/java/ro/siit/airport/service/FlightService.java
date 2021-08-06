package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> findTodayDepartureFlights(Long airportId);

    List<FlightDto> findTodayArrivalFlights(Long airportId);

    Boolean saveRecord(FlightDto FlightDto);
}
