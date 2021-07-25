package ro.siit.Airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    @RequestMapping("/")
    public String getHomepage() {
        return "homepage";
    }
}
