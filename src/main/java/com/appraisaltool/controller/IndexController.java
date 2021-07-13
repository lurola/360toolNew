package com.appraisaltool.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appraisaltool.ApplicationProperties;


@Controller
public class IndexController {
	
	@Autowired ApplicationProperties properties;
	
//	private String redirectTo = "";
    
    @PostMapping({"/login"})
    public ModelAndView getLoginPage() {
    	return new ModelAndView("/login");
    }
    
    @GetMapping({"/home", "/"})
    public ModelAndView signin(@RequestParam Optional<String> error) {
    	return new ModelAndView("/home", "error", error);
    }
    
    @PostMapping({"/home", "/"})
    public ModelAndView signinPost(@RequestParam Optional<String> error) {
    	return new ModelAndView("/home", "error", error);
    }
       
    
    @GetMapping({"/login"})
    public ModelAndView getLoginPage1() {
    	return new ModelAndView("/login");
    }
}

