package com.example.faceittesttask.service.impl;

import com.example.faceittesttask.dto.VisitedVacancyDto;
import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.repository.VacancyRepository;
import com.example.faceittesttask.repository.responsemodel.Count;
import com.example.faceittesttask.service.VacancyService;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;
    private static final Map<Long, Long> vacancyVisitMap =
            new HashMap<>();

    @Override
    public List<Vacancy> findAll(PageRequest pageRequest) {
        return vacancyRepository.findAll(pageRequest).toList();
    }

    @Override
    public Vacancy findById(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No vacancy found with id " + id)
        );
        if (!vacancyVisitMap.containsKey(id)) {
            vacancyVisitMap.put(id, 0L);
        }
        vacancyVisitMap.put(id, vacancyVisitMap.get(id) + 1);
        return vacancy;
    }

    public List<VisitedVacancyDto> getMostVisitedVacancies(int count) {
        List<Map.Entry<Long, Long>> mostVisitedEntries = vacancyVisitMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .toList();
        return mostVisitedEntries.stream()
                .map(entry -> new VisitedVacancyDto(entry.getKey(), entry.getValue()))
                .toList();
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
