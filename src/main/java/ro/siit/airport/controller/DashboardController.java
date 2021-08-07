package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.airport.model.EditFlightDto;
import ro.siit.airport.service.AirlineService;
import ro.siit.airport.service.AirportService;
import ro.siit.airport.service.FlightService;

@Controller
public class DashboardController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String getDashboard(Model model) {
        model.addAttribute("flightDto", flightService.findAllFlights());
        return "dashboard";
    }

    @GetMapping("/dashboard/edit/")
    @PreAuthorize("hasRole('ADMIN')")
    String editRecord(@RequestParam Long id, final Model model) {
        model.addAttribute("flight", flightService.findById(id));
        model.addAttribute("airportDto", airportService.findAll());
        model.addAttribute("airline", airlineService.findAll());
        return "editFlight";
    }

    @PostMapping("/dashboard/edit/")
    @PreAuthorize("hasRole('ADMIN')")
    public String editFlight(@ModelAttribute EditFlightDto editFlightDto, final Model model) {
        model.addAttribute("flight", editFlightDto);
        flightService.updateFlight(editFlightDto);
        return "redirect:/dashboard";
    }
}
