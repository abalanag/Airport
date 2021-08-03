package ro.siit.airport.service;

import ro.siit.airport.model.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> findAll();
}
