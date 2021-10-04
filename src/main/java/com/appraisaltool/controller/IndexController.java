package com.appraisaltool.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.appraisaltool.ApplicationProperties;


@RestController
public class IndexController {
	
	@Autowired ApplicationProperties properties;
	
    @GetMapping({
            "/logout"})
    public ModelAndView getLogoutPage(@RequestParam Optional<String> error) {
        return new ModelAndView("/login", "error", error);
    }

    @GetMapping({"/home", "/"})
    public ModelAndView signin(@RequestParam Optional<String> error) {
    	return new ModelAndView("/home", "error", error);
    }
    
    @PostMapping({"/home", "/"})
    public ModelAndView signinPost(@RequestParam Optional<String> error) {
    	return new ModelAndView("/home", "error", error);
    }
       
    
    @GetMapping({
            "/login"})
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }
}

