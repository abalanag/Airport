package ro.siit.airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

    @RequestMapping({"/", "/home"})
    public String getHomepage() {
        return "homepage";
    }
}
