package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Flight;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.FlightRequestDto;
import ro.siit.airport.repository.FlightRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<FlightDto> findByAirport(final FlightRequestDto flightRequestDto) {
        if (flightRequestDto.getFlightType().equals("departure") || flightRequestDto.getFlightType().equals("Departure")) {

            final List<Flight> flight = flightRepository.retrieveDepartureFlightByAirport(flightRequestDto.getId(), flightRequestDto.getStartDate(), flightRequestDto.getEndDate());
            return flight.stream()
                    .map(f -> new FlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(), f.getArrival(), f.getDepartureAirport().getName(), f.getArrivalAirport().getName(), f.getAirline().getAirlineName()))
                    .collect(Collectors.toList());
        } else {

            final List<Flight> flight = flightRepository.retrieveArrivalFlightByAirport(flightRequestDto.getId(), flightRequestDto.getStartDate(), flightRequestDto.getEndDate());
            return flight.stream()
                    .map(f -> new FlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(), f.getArrival(), f.getDepartureAirport().getName(), f.getArrivalAirport().getName(), f.getAirline().getAirlineName()))
                    .collect(Collectors.toList());
        }
    }
}
