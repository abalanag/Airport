package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.model.AirlineDto;
import ro.siit.airport.repository.AirlineRepository;
import ro.siit.airport.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<AirlineDto> findAll() {
        return airlineRepository.findAll().stream()
                .map(a -> new AirlineDto(a.getId(), a.getAirlineName(), a.getCountry(), a.getIata(), a.getIcao()))
                .collect(Collectors.toList());
    }
}
