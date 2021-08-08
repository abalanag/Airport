package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.siit.airport.model.AirlineDto;
import ro.siit.airport.model.FlightRequestDto;
import ro.siit.airport.service.AirlineService;
import ro.siit.airport.service.CountryService;
import ro.siit.airport.service.FlightService;

import java.util.List;

@Controller
public class SearchByAirlineController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private FlightService flightService;

    @GetMapping("/airline")
    public String retrieveCountries(final Model model) {
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("airlineFlightRequestDto", new FlightRequestDto());
        return "searchByAirline";
    }

    @GetMapping("/airline/airlines")
    public @ResponseBody
    List<AirlineDto> retrieveAirport(@RequestParam("countryId") final Long countryId) {
        return airlineService.findByCountry(countryId);
    }

    @PostMapping("/airline")
    public String viewAirport(FlightRequestDto flightRequestDto, Model model) {
        model.addAttribute("airlineFlightRequestDto", flightRequestDto);
        model.addAttribute("flightDto", flightService.findByAirline(flightRequestDto));
        return "flightResult";
    }

}
