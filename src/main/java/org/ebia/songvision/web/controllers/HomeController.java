package org.ebia.songvision.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
    @GetMapping("/")
    public ModelAndView index(Authentication authentication) {
        if(authentication != null && authentication.isAuthenticated()) {
            return this.view("home");
        }
        
        return this.view("index");
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return this.view("about");
    }
}
