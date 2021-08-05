package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.siit.airport.service.FlightService;

import javax.annotation.security.RolesAllowed;

@Controller
public class DashboardController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/dashboard")
    @RolesAllowed("ROLE_ADMIN")
    public String getDashboard(Model model) {
        model.addAttribute("flightDto", flightService.findAll());
        return "dashboard";
    }

    @GetMapping("/dashboard/delete/{id}")
    public @ResponseBody
    String deleteRecord(@RequestParam Long id) {
        flightService.deleteRecord(id);
        return "dashboard";
    }
}
