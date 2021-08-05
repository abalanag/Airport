package ro.siit.airport.service;

import ro.siit.airport.model.AirportDto;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<AirportDto> findByCountry(Long countryId);

    Optional<AirportDto> findById(Long airportId);
}
