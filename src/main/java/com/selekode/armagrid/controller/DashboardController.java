package com.selekode.armagrid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@GetMapping("/")
	public String loadPageDashboard(Model model) {
		System.out.println("Access dashboard");

		return "dashboard"; // dashboard.html in templates folder
	}

}
