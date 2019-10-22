
package edu.nguyenvanson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class homeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home() {
        return "home/index";
    }

}
