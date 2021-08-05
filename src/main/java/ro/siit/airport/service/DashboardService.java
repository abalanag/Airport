package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;

import java.util.List;

public interface DashboardService {
    List<FlightDto> findAllFlights();
}
