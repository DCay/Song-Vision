package org.ebia.songvision.web.controllers;

import org.ebia.songvision.business.models.UserServiceModel;
import org.ebia.songvision.business.services.UserService;
import org.ebia.songvision.business.utilities.MappingUtility;
import org.ebia.songvision.web.models.UserRegisterBindingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private final MappingUtility mappingUtility;

    private final UserService userService;

    @Autowired
    public UserController(MappingUtility mappingUtility, UserService userService) {
        this.mappingUtility = mappingUtility;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return this.view("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return this.view("register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel) {
        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return this.view("register");
        }

        this.userService.saveUser(
            this.mappingUtility.map(userRegisterBindingModel, UserServiceModel.class)
        );

        return this.redirect("/login");
    }
}
