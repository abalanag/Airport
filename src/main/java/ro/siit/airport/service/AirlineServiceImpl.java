package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.domain.Country;
import ro.siit.airport.model.AirlineDto;
import ro.siit.airport.repository.AirlineRepository;
import ro.siit.airport.repository.CountryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    @Transactional
    public List<AirlineDto> findByCountry(final Long countryId) {
        return airlineRepository.findByCountry(countryRepository.findById(countryId)
                        .orElse(new Country(0L, "N/A", "N/A")))
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<AirlineDto> findAll() {
        return airlineRepository.findAll().stream()
                .map(a -> new AirlineDto(
                        a.getId(),
                        a.getAirlineName(),
                        a.getCountry(),
                        a.getIata(),
                        a.getIcao()))
                .collect(Collectors.toList());
    }
}
