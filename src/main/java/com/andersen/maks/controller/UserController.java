package com.andersen.maks.controller;

import com.andersen.maks.entity.User;
import com.andersen.maks.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String index(){

        //logs debug message
        if(logger.isDebugEnabled()){
            logger.debug("getWelcome is executed!");
        }

        //logs exception
        logger.error("This is Error message", new Exception("Testing"));
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("/userById/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "showUsers";

    }


    @GetMapping("/addUser")
    public String createUserPage(){
        return "/createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }
}
