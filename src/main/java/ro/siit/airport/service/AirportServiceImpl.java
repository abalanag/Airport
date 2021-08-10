package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Country;
import ro.siit.airport.model.AirportDto;
import ro.siit.airport.repository.AirportRepository;
import ro.siit.airport.repository.CountryRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
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
        return airportRepository.findByCountry(countryRepository.findById(countryId)
                        .orElse(new Country(0L, "N/A", "N/A")))
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public AirportDto findAirportById(final Long airportId) {
        return airportRepository.findAirportById(airportId)
                .orElse(new AirportDto(0L, "N/A", "N/A", BigDecimal.ZERO, BigDecimal.ZERO, Boolean.FALSE));
    }

    public List<AirportDto> findAll() {
        return airportRepository.findAll().stream()
                .map(a -> new AirportDto(
                        a.getId(),
                        a.getName(),
                        a.getCity(),
                        a.getLatitude(),
                        a.getLongitude(),
                        a.getActive()))
                .collect(Collectors.toList());
    }
}
