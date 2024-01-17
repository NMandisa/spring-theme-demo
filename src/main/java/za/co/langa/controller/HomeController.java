package za.co.langa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Noxolo.Mkhungo
 */
@Controller
public class HomeController {
    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
