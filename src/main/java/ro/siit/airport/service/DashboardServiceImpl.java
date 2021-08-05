package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.repository.FlightRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private FlightRepository flightRepository;

    public List<FlightDto> findAllFlights() {

        return flightRepository.findAll()
                .stream()
                .map(f -> new FlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(), f.getArrival(),
                        f.getDepartureAirport().getName(), f.getArrivalAirport().getName(), f.getAirline().getAirlineName()))
                .collect(Collectors.toList());
    }
}
