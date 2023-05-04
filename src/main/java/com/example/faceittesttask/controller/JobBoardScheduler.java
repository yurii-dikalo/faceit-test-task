package com.example.faceittesttask.controller;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.example.faceittesttask.dto.JobBoardApiDto;
import com.example.faceittesttask.dto.VacancyApiDto;
import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.service.HttpClient;
import com.example.faceittesttask.service.VacancyService;
import com.example.faceittesttask.service.mapper.impl.VacancyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Log4j2
@RequiredArgsConstructor
@Controller
public class JobBoardScheduler {
    private static final int FIRST_PAGE_TO_READ = 1;
    private static final int LAST_PAGE_TO_READ = 5;
    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;
    private final HttpClient client;
    @Value("${api.url}")
    private String apiUrl;

    @Scheduled(fixedRate = 60, timeUnit = TimeUnit.MINUTES)
    public void init() {
        JobBoardApiDto jobBoardApiDto = client.get(apiUrl, JobBoardApiDto.class);
        List<VacancyApiDto> vacancyDtos = new ArrayList<>(jobBoardApiDto.data());
        int counter = FIRST_PAGE_TO_READ;
        while (nonNull(jobBoardApiDto.links().next()) && counter++ < LAST_PAGE_TO_READ) {
            jobBoardApiDto = client.get(jobBoardApiDto.links().next(), JobBoardApiDto.class);
            vacancyDtos.addAll(jobBoardApiDto.data());

        }
        log.info("Number of loaded vacancies: {}", vacancyDtos.size());
        vacancyService.saveAll(filterExistingVacancies(vacancyDtos));
    }

    private List<Vacancy> filterExistingVacancies(List<VacancyApiDto> vacancyDtos) {
        Set<String> existingSlugs = vacancyService.findAllSlugs();
        List<Vacancy> newVacancies = vacancyDtos.stream()
                .filter(vacancyDto -> !existingSlugs.contains(vacancyDto.slug()))
                .map(vacancyMapper::toModel)
                .toList();
        log.info("Number of new vacancies: {}", newVacancies.size());
        return newVacancies;
    }
}


