package ro.siit.airport.service;

import ro.siit.airport.model.AirlineDto;
import java.util.List;
import java.util.Optional;

public interface AirlineService {
    List<AirlineDto> findByCountry(Long countryId);

    Optional<AirlineDto> findAirlineById(Long airlineId);

    List<AirlineDto> findAll();
}
