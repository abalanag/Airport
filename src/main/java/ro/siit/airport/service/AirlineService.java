package ro.siit.airport.service;

import ro.siit.airport.model.AirlineDto;

import java.util.List;

public interface AirlineService {
    List<AirlineDto> findAll();
}
