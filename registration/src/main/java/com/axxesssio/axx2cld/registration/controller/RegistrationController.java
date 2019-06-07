package com.axxesssio.axx2cld.registration.controller;

import com.axxessio.axx2cld.registration.entities.User;
import com.axxessio.axx2cld.registration.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

@Autowired
    private UserValidator userValidator;

@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

return "registration";
    }

@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, 
     BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

if (bindingResult.hasErrors()) {
            return "registration";
        }

userService.save(userForm);


return "redirect:/welcome";
    }

}