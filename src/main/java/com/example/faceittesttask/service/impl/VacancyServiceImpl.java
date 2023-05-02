package com.example.faceittesttask.service.impl;

import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.repository.VacancyRepository;
import com.example.faceittesttask.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;

    @Override
    public List<Vacancy> findAll(PageRequest pageRequest) {
        return vacancyRepository.findAll(pageRequest).toList();
    }
}
