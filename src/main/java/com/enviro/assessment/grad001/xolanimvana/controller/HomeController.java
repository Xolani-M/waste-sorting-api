package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String welcomeMessage() {
        return "<div style='text-align:center; font-size:2em; margin-top:10%; padding:20px; "
             + "background: linear-gradient(135deg, #76c7c0, #90e0ef); color: white; border-radius:15px; "
             + "box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); font-family: Arial, sans-serif; font-weight: bold;'>"
             + "🌟 Welcome to the <span style='color:#0077b6;'>Waste Sorting API</span>! 🌍<br>"
             + "Let's make <span style='color:#0077b6;'>recycling</span> fun and save the planet together! 🚀"
             + "</div>";
    }
}
