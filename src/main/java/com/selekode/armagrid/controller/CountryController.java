package com.selekode.armagrid.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.selekode.armagrid.model.Country;
import com.selekode.armagrid.model.CountryStats;
import com.selekode.armagrid.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {
	
	@GetMapping("/")
	public String loadPage(Model model) {
		System.out.println("Access countries");
		model.addAttribute("countries", CountryService.getAllCountries());

		return "paises"; // dashboard.html in templates folder
	}
	
	@PostMapping("/stats")
	public String loadCountryInfo(@RequestParam("selectedCountryId") int countryId, Model model) {   
	    model.addAttribute("country", CountryService.getCountry(countryId));
	    model.addAttribute("stats", CountryService.getCountryStats(countryId));
	    model.addAttribute("selectedCountryId", countryId);
	    model.addAttribute("countries", CountryService.getAllCountries());
	    return "paises"; // your Thymeleaf page
	}

}
