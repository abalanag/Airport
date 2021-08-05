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
    private FlightRepository flightRepository;

    public List<FlightDto> findTodayDepartureFlights(final Long airportId) {
        return flightRepository.findFlightsByDepartureAirport(airportId).stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<FlightDto> findTodayArrivalFlights(final Long airportId) {
        return flightRepository.findFlightsByArrivalAirport(airportId).stream()
                .limit(10)
                .collect(Collectors.toList());
    }
}
