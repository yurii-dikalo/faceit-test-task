package com.example.faceittesttask.controller;

import com.example.faceittesttask.dto.VacancyDto;
import com.example.faceittesttask.service.VacancyService;
import com.example.faceittesttask.service.mapper.impl.VacancyMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;

    @Operation(description = "Get the list of all vacancies sorted and with pagination.")
    @GetMapping
    public List<VacancyDto> findAll() {
        return null;
    }
}
