package com.example.faceittesttask.service;

import com.example.faceittesttask.model.Vacancy;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface VacancyService {
    List<Vacancy> findAll(PageRequest pageRequest);

    void saveAll(List<Vacancy> vacancies);
}
