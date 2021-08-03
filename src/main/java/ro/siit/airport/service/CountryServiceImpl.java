package ro.siit.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.airport.model.CountryDto;
import ro.siit.airport.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(a -> new CountryDto(a.getId(), a.getName(), a.getCountryCode()))
                .collect(Collectors.toList());
    }
}

