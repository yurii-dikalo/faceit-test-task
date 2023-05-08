package com.example.faceittesttask.service;

import com.example.faceittesttask.dto.VisitedVacancyDto;
import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.repository.responsemodel.Count;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.Set;

public interface VacancyService {
    List<Vacancy> findAll(PageRequest pageRequest);

    Vacancy findById(Long id);

    List<VisitedVacancyDto> getMostVisitedVacancies(int number);

    void saveAll(List<Vacancy> vacancies);

    List<Count> getCountByLocation();

    Set<String> findAllSlugs();
}
