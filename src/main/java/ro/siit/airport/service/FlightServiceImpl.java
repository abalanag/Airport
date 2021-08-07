package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.repository.FlightRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<FlightDto> findAll() {
        return flightRepository.findAll()
                .stream()
                .map(f -> new FlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(), f.getArrival(),
                        f.getDepartureAirport().getName(), f.getArrivalAirport().getName(), f.getAirline().getAirlineName()))
                .collect(Collectors.toList());
    }

    public boolean deleteRecord(Long id) {
        flightRepository.findById(id).ifPresent(f -> flightRepository.delete(f));
        return flightRepository.findById(id).isEmpty();
    }
}
