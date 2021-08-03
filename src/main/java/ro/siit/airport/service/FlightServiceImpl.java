package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Flight;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.AirlineFlightRequestDto;
import ro.siit.airport.repository.FlightRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<FlightDto> findByAirline(final AirlineFlightRequestDto airlineFlightRequestDto) {

            final List<Flight> flight = flightRepository.retrieveDepartureFlightByAirline(airlineFlightRequestDto.getId(), airlineFlightRequestDto.getStartDate(), airlineFlightRequestDto.getEndDate());
            return flight.stream()
                    .map(f -> new FlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(), f.getArrival(), f.getDepartureAirportId().getName(), f.getArrivalAirportId().getName(), f.getAirlineId().getAirlineName()))
                    .collect(Collectors.toList());
    }
}
