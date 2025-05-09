package com.github.jbreno.main.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/primeiraController")
public class PrimeiraController {

    @GetMapping(path = "/primeiroMapping")
    public String primeiroMapping(@RequestParam Map<String, String> allParam) {
        return "Primeiro Mapping: " + allParam.entrySet();
    }
}
