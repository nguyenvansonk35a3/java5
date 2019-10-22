package edu.nguyenvanson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.nguyenvanson.domain.User;
import edu.nguyenvanson.services.UserService;
import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping
    @ResponseBody
    public String hello() {
        return "This is hello";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<User> list = new ArrayList<>();
        List<edu.nguyenvanson.models.User> users = userService.findAll();
        for (edu.nguyenvanson.models.User user : users) {
            User usr = new User();
            usr.setUsername(user.getUsername());
            usr.setPassword(user.getPassword());
            usr.setFullname(user.getFullname());

            list.add(usr);
        }
        model.addAttribute("users", list);
        
        return "users/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        model.addAttribute("user", new User());
        return "users/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid User user, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "users/add";
        }
        model.addAttribute("message", "New user has been inserted!");
        System.out.println(user.getUsername());
        model.addAttribute("user", new User());

        edu.nguyenvanson.models.User usr = new edu.nguyenvanson.models.User();
        usr.setUsername(user.getUsername());
        usr.setPassword(user.getPassword());
        usr.setFullname(user.getFullname());

        userService.save(usr);
        return "users/add";
    }

    
    @RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
    public String edit(@PathVariable(name = "username") String username, ModelMap model) {
        List<User> list = new ArrayList<>();
        Optional<edu.nguyenvanson.models.User> user = userService.findById(username);
        User usr = new User();
        if (user.isPresent()) {
            usr.setUsername(user.get().getUsername());
            usr.setPassword(user.get().getPassword());
            usr.setFullname(user.get().getFullname());
        }
        model.addAttribute("user", usr);
        return "users/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(ModelMap model, User user) {
        edu.nguyenvanson.models.User usr = new edu.nguyenvanson.models.User();
        usr.setUsername(user.getUsername());
        usr.setPassword(user.getPassword());
        usr.setFullname(user.getFullname());

        userService.save(usr);
        return "redirect:/users/view";
    }
    
    @RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
    public String delete(@PathVariable(name="username") String username){
        userService.deleteById(username);
        return "redirect:/users/view";
    }
}
