package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("user")

public class UserController {

    @GetMapping("add")

    public String displayAddUserForm() {

        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {
        // add form submission handling code here

        if (user.getPassword().equals(verify)) {
            return "user/index";
        } else {
            model.addAttribute("Error", "Error!! Password are supposed to match . . . !");

            return "user/add";
        }

//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//        model.addAttribute("Error", "Error!! Password are supposed to match . . . !");
//        return "user/add";

    }
}
