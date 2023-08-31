package com.spring.springcrudproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CityController {

    @GetMapping("/cities")
    public String getCities(Model model) {
        List<String> cities = new ArrayList<>();
        cities.add("Berlin");
        cities.add("Toronto");
        cities.add("Saint Petersburg");
        cities.add("Tyumen");

        model.addAttribute("cities", cities);
        return "citiesView";
    }
}
