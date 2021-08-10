package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.domain.Country;
import ro.siit.airport.domain.Flight;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.model.FlightRequestDto;
import ro.siit.airport.repository.AirlineRepository;
import ro.siit.airport.repository.AirportRepository;
import ro.siit.airport.repository.FlightRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<FlightDto> findTodayDepartureFlights(final Long airportId) {
        return flightRepository.findFlightsByDepartureAirport(airportRepository
                        .findById(airportId)
                        .orElse(new Airport(0L, "N/a", "N/A", new Country(), BigDecimal.ZERO, BigDecimal.ZERO, Boolean.FALSE)))
                .stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> findTodayArrivalFlights(final Long airportId) {
        return flightRepository.findFlightsByArrivalAirport(airportRepository
                        .findById(airportId)
                        .orElse(new Airport(0L, "N/A", "N/A", new Country(), BigDecimal.ZERO, BigDecimal.ZERO, Boolean.FALSE)))
                .stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> findByAirport(final FlightRequestDto flightRequestDto) {
        if (flightRequestDto.getFlightType().equals("departure") || flightRequestDto.getFlightType().equals("Departure")) {
            return flightRepository.retrieveDepartureFlightByAirport(flightRequestDto.getAirport(), flightRequestDto.getStartDate(), flightRequestDto.getEndDate())
                    .stream()
                    .collect(Collectors.toList());

        } else {
            return flightRepository.retrieveArrivalFlightByAirport(flightRequestDto.getAirport(), flightRequestDto.getStartDate(), flightRequestDto.getEndDate())
                    .stream()
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<FlightDto> findByAirline(final FlightRequestDto flightRequestDto) {
        if (flightRequestDto.getFlightType().equals("departure") || flightRequestDto.getFlightType().equals("Departure")) {
            return flightRepository.retrieveDepartureFlightByAirline(flightRequestDto.getAirline(), flightRequestDto.getStartDate(), flightRequestDto.getEndDate())
                    .stream()
                    .collect(Collectors.toList());
        } else {
            return flightRepository.retrieveArrivalFlightByAirline(flightRequestDto.getAirline(), flightRequestDto.getStartDate(), flightRequestDto.getEndDate())
                    .stream()
                    .collect(Collectors.toList());
        }
    }


    @Override
    public Boolean saveRecord(final FlightDto flightDto) {
        Flight flight = new Flight(
                flightDto.getFlightNumber(),
                flightDto.getDeparture(),
                flightDto.getArrival(),
                flightDto.getDepartureAirport(),
                flightDto.getArrivalAirport(),
                flightDto.getAirline());
        final Flight savedFlight = flightRepository.save(flight);
        return (savedFlight.getId() != null);
    }

    @Override
    public FlightDto findById(final Long id) {
        return flightRepository
                .findById(id).map(f -> new FlightDto(
                        f.getId(),
                        f.getFlightNumber(),
                        f.getDeparture(),
                        f.getArrival(),
                        f.getDepartureAirport(),
                        f.getArrivalAirport(),
                        f.getAirline()))
                .orElse(new FlightDto(1L, "N/A", LocalDateTime.now(), LocalDateTime.now(), new Airport(), new Airport(), new Airline()));
    }

    @Override
    public List<FlightDto> findAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(f -> new FlightDto(
                        f.getId(),
                        f.getFlightNumber(),
                        f.getDeparture(),
                        f.getArrival(),
                        f.getDepartureAirport(),
                        f.getArrivalAirport(),
                        f.getAirline()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateFlight(final FlightDto flightDto) {
        Optional<Flight> flight = flightRepository.findById(flightDto.getId())
                .map(f -> new Flight(
                        flightDto.getId(),
                        flightDto.getFlightNumber(),
                        flightDto.getDeparture(),
                        flightDto.getArrival(),
                        flightDto.getDepartureAirport(),
                        flightDto.getArrivalAirport(),
                        flightDto.getAirline()));
        flight.ifPresent(f -> flightRepository.save(f));
        return flightRepository.getById(flight.get().getId()) != null;
    }

    @Override
    public Boolean deleteRecord(final Long id) {
        flightRepository.findById(id).ifPresent(f -> flightRepository.delete(f));
        return flightRepository.findById(id).isEmpty();
    }
}
