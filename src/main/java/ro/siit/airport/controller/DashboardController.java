package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.siit.airport.model.FlightDto;
import ro.siit.airport.service.AirlineService;
import ro.siit.airport.service.AirportService;
import ro.siit.airport.service.FlightService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@Controller
public class DashboardController {

    @Autowired
    AirportService airportService;

    @Autowired
    FlightService flightService;

    @Autowired
    AirlineService airlineService;

    @GetMapping("/dashboard")
    @RolesAllowed("ROLE_ADMIN")
    public String getDashboard(Model model) {
        model.addAttribute("flightDto", flightService.findAllFlights());
        return "dashboard";
    }

    @GetMapping("/new-flight")
    @RolesAllowed("ROLE_ADMIN")
    public String retrieveNewFlightInfo(final Model model) {
        model.addAttribute("flightDto", new FlightDto());
        model.addAttribute("airportDto", airportService.findAll());
        model.addAttribute("airlineDto", airlineService.findAll());
        return "add-new-flight";
    }

    @PostMapping("/new-flight")
    @RolesAllowed("ROLE_ADMIN")
    public String postNewFlight(@Valid @ModelAttribute("flightDto") FlightDto flightDto, final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("flightDto", flightDto);
            model.addAttribute("airportDto", airportService.findAll());
            model.addAttribute("airlineDto", airlineService.findAll());
            return "add-new-flight";
        } else {
            flightService.saveRecord(flightDto);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/dashboard/edit/")
    @PreAuthorize("hasRole('ADMIN')")
    String editRecord(@RequestParam Long id, final Model model) {
        model.addAttribute("flight", flightService.findById(id));
        model.addAttribute("airportDto", airportService.findAll());
        model.addAttribute("airlineDto", airlineService.findAll());
        return "edit-flight";
    }

    @PostMapping("/dashboard/edit/")
    @PreAuthorize("hasRole('ADMIN')")
    public String editFlight(@ModelAttribute FlightDto flightDto, final Model model) {
        model.addAttribute("flight", flightDto);
        flightService.updateFlight(flightDto);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard/delete/")
    public @ResponseBody
    String deleteRecord(@RequestParam Long id) {
        flightService.deleteRecord(id);
        return "dashboard";
    }
}
