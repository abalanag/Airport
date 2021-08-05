package ro.siit.airport.service;

import ro.siit.airport.model.FlightDto;

import java.util.List;


public interface FlightService {

    List<FlightDto> findAll();

    boolean deleteRecord(Long id);

}
