package com.enviro.assessment.grad001.sikhoqangule.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class WasteCategoryController {

    @GetMapping
    public String getAllCategories() {
        return "Works";
    }
}