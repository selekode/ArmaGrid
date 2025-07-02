package com.selekode.armagrid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test() {
        System.out.println("✅ /test endpoint hit!");
        return "dashboard"; // Or a minimal template in templates folder
    }
}
