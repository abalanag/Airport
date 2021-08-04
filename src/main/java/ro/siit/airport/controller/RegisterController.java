package ro.siit.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.siit.airport.model.RegisterDto;
import ro.siit.airport.service.RegisterService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public ModelAndView showRegisterForm() {
        final ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("register", new RegisterDto());
        return mav;
    }

    @PostMapping
    public String processForm(@Valid @ModelAttribute("register") final RegisterDto registerDto, final BindingResult bindingResult,
                              final Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            registerService.saveUser(registerDto);
            return "homepage";
        }
    }
}
