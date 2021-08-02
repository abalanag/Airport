package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.siit.airport.model.AirportDto;
import ro.siit.airport.service.AirportService;
import ro.siit.airport.service.CountryService;

import java.util.List;

@Controller
public class AirportController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    public String retrieveCountries(final Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "country";
    }

    @GetMapping("/countries/airports")
    public @ResponseBody
    List<AirportDto> retrieveAirport(@RequestParam("countryId") final Long countryId) {
        return airportService.findByCountry(countryId);
    }

    @PostMapping("/airports")
    public String viewAirport(@RequestParam("airportDto") final Long airportId, final Model model, final AirportDto airportDto) {
        if (airportId == -1) {
            return "country";
        } else {
            airportService.findById(airportId).ifPresent(a -> model.addAttribute("airportDto", a));
            return "airport";
        }
    }

}
