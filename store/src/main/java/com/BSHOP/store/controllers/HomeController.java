package com.BSHOP.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BSHOP.store.repositories.SizeRepository;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private SizeRepository sizeRepository;

    @GetMapping
    public String getHome() {
        System.out.println(sizeRepository.getAllSizes());
        return "home";
    }

}