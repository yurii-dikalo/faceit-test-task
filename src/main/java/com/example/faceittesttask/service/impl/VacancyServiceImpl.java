package com.example.faceittesttask.service.impl;

import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.repository.VacancyRepository;
import com.example.faceittesttask.repository.responsemodel.Count;
import com.example.faceittesttask.service.VacancyService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;

    @Override
    public List<Vacancy> findAll(PageRequest pageRequest) {
        return vacancyRepository.findAll(pageRequest).toList();
    }

    @Override
    public void saveAll(List<Vacancy> vacancies) {
        vacancyRepository.saveAll(vacancies);
    }

    @Override
    public List<Count> getCountByLocation() {
        return vacancyRepository.getCountByLocation();
    }

    @Override
    public Set<String> findAllSlugs() {
        return new HashSet<>(vacancyRepository.findAllSlugs());
    }
}
