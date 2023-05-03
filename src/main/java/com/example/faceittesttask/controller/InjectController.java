package com.example.faceittesttask.controller;

import com.example.faceittesttask.dto.JobBoardApiDto;
import com.example.faceittesttask.dto.VacancyApiDto;
import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.service.HttpClient;
import com.example.faceittesttask.service.VacancyService;
import com.example.faceittesttask.service.mapper.impl.VacancyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Controller
public class InjectController {
    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;
    private final HttpClient client;
    @Value("${api.url}")
    private String apiUrl;

    @PostConstruct
    public void init() {
        JobBoardApiDto jobBoardApiDto = client.get(apiUrl, JobBoardApiDto.class);
        List<VacancyApiDto> vacancyDtos = new ArrayList<>(jobBoardApiDto.data());
        int counter = 0;
        while(nonNull(jobBoardApiDto.links().next()) && counter++ < 5) {
            jobBoardApiDto = client.get(jobBoardApiDto.links().next(), JobBoardApiDto.class);
            vacancyDtos.addAll(jobBoardApiDto.data());

        }
        List<Vacancy> vacancies = vacancyDtos.stream()
                .map(vacancyMapper::toModel)
                .toList();
        vacancyService.saveAll(vacancies);
    }
}


