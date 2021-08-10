package ro.siit.airport.service;

import ro.siit.airport.model.AirportDto;

import java.util.List;

public interface AirportService {

    List<AirportDto> findByCountry(Long countryId);
    AirportDto findAirportById(Long airportId);
    List<AirportDto> findAll();
}
