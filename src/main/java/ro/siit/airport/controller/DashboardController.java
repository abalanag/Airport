package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.service.AirlineService;
import ro.siit.airport.service.AirportService;
import ro.siit.airport.service.DashboardService;
import ro.siit.airport.service.FlightService;

import javax.annotation.security.RolesAllowed;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    AirportService airportService;

    @Autowired
    FlightService flightService;

    @Autowired
    AirlineService airlineService;

    @GetMapping("/dashboard")
    @RolesAllowed("ROLE_ADMIN")
    public String getDashboard(Model model) {
        model.addAttribute("flightDto", dashboardService.findAllFlights());
        return "dashboard";
    }

    @GetMapping("/new-flight")
    @RolesAllowed("ROLE_ADMIN")
    public String retrieveNewFlightInfo(final Model model) {
        model.addAttribute("flightDto", new FlightDto());
        model.addAttribute("airportDto", airportService.findAll());
        model.addAttribute("airlineDto", airlineService.findAll());
        return "addNewFlight";
    }

    @PostMapping("/new-flight")
    @RolesAllowed("ROLE_ADMIN")
    public String postNewFlight(@Validated final FlightDto flightDto, final Model model, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("flightDto", new FlightDto());
            model.addAttribute("airportDto", airportService.findAll());
            model.addAttribute("airlineDto", airlineService.findAll());
            return "addNewFlight";
        } else {
            flightService.saveRecord(flightDto);
            model.addAttribute("flightDto", dashboardService.findAllFlights());
            return "dashboard";
        }
    }
}
