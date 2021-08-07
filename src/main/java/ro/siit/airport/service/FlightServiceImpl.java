package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.domain.Country;
import ro.siit.airport.domain.Flight;
import ro.siit.airport.model.AirlineFlightRequestDto;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.FlightRequestDto;
import ro.siit.airport.repository.AirlineRepository;
import ro.siit.airport.repository.AirportRepository;
import ro.siit.airport.repository.FlightRepository;
import ro.siit.airport.model.EditFlightDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Override
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

    @Override
    public List<FlightDto> findByAirline(final AirlineFlightRequestDto airlineFlightRequestDto) {
        final List<Flight> flight = flightRepository.retrieveDepartureFlightByAirline(airlineFlightRequestDto.getId(), airlineFlightRequestDto.getStartDate(), airlineFlightRequestDto.getEndDate());
        return flight.stream()
                .map(f -> new FlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(), f.getArrival(), f.getDepartureAirport().getName(), f.getArrivalAirport().getName(), f.getAirline().getAirlineName()))
                .collect(Collectors.toList());
    }

    @Override
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

    public EditFlightDto findById(final Long id) {
        return flightRepository.findById(id).map(f -> new EditFlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(),
                f.getArrival(), f.getDepartureAirport(), f.getArrivalAirport(), f.getAirline())).orElse(new EditFlightDto(1L, "N/A",
                LocalDateTime.now(), LocalDateTime.now(), new Airport(), new Airport(), new Airline()));
    }

    public List<FlightDto> findAllFlights() {

        return flightRepository.findAll()
                .stream()
                .map(f -> new FlightDto(f.getId(), f.getFlightNumber(), f.getDeparture(), f.getArrival(),
                        f.getDepartureAirport().getName(), f.getArrivalAirport().getName(), f.getAirline().getAirlineName()))
                .collect(Collectors.toList());
    }

    public Boolean updateFlight(final EditFlightDto editFlightDto) {
        Flight flight = new Flight();
        flight.setId(editFlightDto.getId());
        flight.setFlightNumber(editFlightDto.getFlightNumber());
        flight.setDeparture(editFlightDto.getDeparture());
        flight.setArrival(editFlightDto.getArrival());
        flight.setDepartureAirport(airportRepository.findAirportById(editFlightDto.getDepartureAirport().getId())
                .orElseGet(() -> new Airport(-1L, "N/A", "N/A", new Country(), BigDecimal.ZERO, BigDecimal.ZERO, Boolean.FALSE)));
        flight.setArrivalAirport(airportRepository.findAirportById(editFlightDto.getArrivalAirport().getId()).orElseGet(
                () -> new Airport(-1L, "N/A", "N/A", new Country(), BigDecimal.ZERO, BigDecimal.ZERO, Boolean.FALSE)));
        flight.setAirline(airlineRepository.findById(editFlightDto.getAirline().getId()).orElseGet(
                () -> new Airline(-1L, "N/A", new Country(), "N/A", "N/A")));
        final Flight savedFlight = flightRepository.save(flight);
        return (savedFlight.getId() != null);
    }
}
