package com.example.genderapi.controller;

import com.example.genderapi.dto.GenderDto;
import com.example.genderapi.service.ExternalGenderService;
import com.example.genderapi.service.MainGenderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderController {

    private MainGenderService mainGenderService;

    public GenderController(MainGenderService mainGenderService) {
        this.mainGenderService = mainGenderService;
    }

    @GetMapping("/gender/info/{name}")
    public GenderDto genderDto(@PathVariable String name) {
        return mainGenderService.getGenderData(name);
    }
}
