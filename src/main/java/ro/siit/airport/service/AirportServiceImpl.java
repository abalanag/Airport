package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Airport;
import ro.siit.airport.model.AirportDto;
import ro.siit.airport.repository.AirportRepository;
import ro.siit.airport.repository.CountryRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Override
    @Transactional
    public List<AirportDto> findByCountry(final Long countryId) {
        final List<Airport> airport = countryRepository.findById(countryId)
                .map(a -> airportRepository.findByCountry(a))
                .orElse(new ArrayList<>());
        return airport.stream()
                .map(a -> new AirportDto(a.getId(), a.getName(), a.getCity(), a.getLatitude(), a.getLongitude(), a.getActive()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AirportDto> findById(final Long airportId) {
        return airportRepository.findAirportById(airportId)
                .map(a -> new AirportDto(a.getId(), a.getName(), a.getCity(), a.getLatitude(),
                        a.getLongitude(), a.getActive()));
    }

    @Override
    public List<AirportDto> findAll() {
        return airportRepository.findAll().stream()
                .map(a -> new AirportDto(a.getId(), a.getName(), a.getCity(), a.getLatitude(), a.getLongitude(), a.getActive()))
                .collect(Collectors.toList());
    }
}
