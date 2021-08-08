package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.siit.airport.model.AirportDto;
import ro.siit.airport.model.FlightRequestDto;
import ro.siit.airport.service.AirportService;
import ro.siit.airport.service.CountryService;
import ro.siit.airport.service.FlightService;

import java.util.List;

@Controller
public class SearchFlyController {

    @Autowired
    CountryService countryService;

    @Autowired
    AirportService airportService;

    @Autowired
    FlightService flightService;

    @GetMapping("/search")
    public String retrieveCountries(final Model model) {
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("flightRequestDto", new FlightRequestDto());
        return "searchByAirport";
    }

    @GetMapping("/search/airports")
    public @ResponseBody
    List<AirportDto> retrieveAirport(@RequestParam("countryId") final Long countryId) {
        return airportService.findByCountry(countryId);
    }

    @PostMapping("/search")
    public String viewAirport(FlightRequestDto flightRequestDto, Model model) {
        model.addAttribute("flightRequestDto", flightRequestDto);
        model.addAttribute("flightDto", flightService.findByAirport(flightRequestDto));
        return "flightResult";
    }
}
