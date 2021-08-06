package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.domain.Country;
import ro.siit.airport.domain.Flight;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.repository.AirlineRepository;
import ro.siit.airport.repository.AirportRepository;
import ro.siit.airport.repository.FlightRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirlineRepository airlineRepository;

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

    public Boolean saveRecord(final FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setDeparture(flightDto.getDeparture());
        flight.setArrival(flightDto.getArrival());
        flight.setDepartureAirport(airportRepository.findAirportById(Long.parseLong(flightDto.getDepartureAirport())).orElseGet(
                () -> new Airport(2L, "N/A", "N/A", new Country(), BigDecimal.ZERO, BigDecimal.ZERO, Boolean.FALSE)));
        flight.setArrivalAirport(airportRepository.findAirportById(Long.parseLong(flightDto.getArrivalAirport())).orElseGet(
                () -> new Airport(-1L, "N/A", "N/A", new Country(), BigDecimal.ZERO, BigDecimal.ZERO, Boolean.FALSE)));
        flight.setAirline(airlineRepository.findById(Long.parseLong(flightDto.getAirline())).orElseGet(
                () -> new Airline(-1L, "N/A", new Country(), "N/A", "N/A")));
        final Flight savedFlight = flightRepository.save(flight);
        return (savedFlight.getId() != null);
    }
}
