package com.example.faceittesttask.service;

import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.repository.VacancyRepository;
import com.example.faceittesttask.repository.responsemodel.Count;
import com.example.faceittesttask.service.impl.VacancyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class VacancyServiceTest {

    private VacancyService vacancyService;
    @Mock
    private VacancyRepository vacancyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        vacancyService = new VacancyServiceImpl(vacancyRepository);
        Vacancy projectManager1 = new Vacancy();
        projectManager1.setSlug("project-manager-1");
        projectManager1.setLocation("Berlin");
        Vacancy software1 = new Vacancy();
        software1.setSlug("software-engineer-1");
        software1.setLocation("Munich");
    }

    @Test
    void testGetCountByLocation() {
        List<Count> counts = new ArrayList<>();
        counts.add(new Count("Berlin", 1));
        counts.add(new Count("Munich", 1));

        when(vacancyRepository.getCountByLocation()).thenReturn(counts);

        List<Count> result = vacancyService.getCountByLocation();

        assertEquals(counts, result);
    }

    @Test
    void testFindAllSlugs() {
        List<String> slugs = new ArrayList<>();
        slugs.add("project-manager-1");
        slugs.add("software-engineer-1");

        Set<String> expectedSlugs = Set.of("project-manager-1", "software-engineer-1");

        when(vacancyRepository.findAllSlugs()).thenReturn(slugs);

        Set<String> result = vacancyService.findAllSlugs();

        assertEquals(expectedSlugs, result);
    }
}