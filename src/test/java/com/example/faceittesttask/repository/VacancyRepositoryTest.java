package com.example.faceittesttask.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.repository.responsemodel.Count;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class VacancyRepositoryTest {
    @Autowired
    private VacancyRepository vacancyRepository;

    @BeforeEach
    void setUp() {
        Vacancy software1 = new Vacancy();
        software1.setSlug("software-engineer-1");
        software1.setLocation("Munich");
        vacancyRepository.save(software1);

        Vacancy projectManager1 = new Vacancy();
        projectManager1.setSlug("product-manager-1");
        projectManager1.setLocation("Berlin");
        vacancyRepository.save(projectManager1);

        Vacancy software2 = new Vacancy();
        software2.setSlug("software-engineer-2");
        software2.setLocation("Berlin");
        vacancyRepository.save(software2);

    }

    @Test
    void testGetCountByLocation() {
        List<Count> counts = vacancyRepository.getCountByLocation();
        assertNotNull(counts);
        assertEquals(2, counts.size());

        Count count1 = counts.get(0);
        assertEquals("Berlin", count1.location());
        assertEquals(2, count1.count());

        Count count2 = counts.get(1);
        assertEquals("Munich", count2.location());
        assertEquals(1, count2.count());
    }

    @Test
    void testFindAllSlugs() {
        List<String> slugs = vacancyRepository.findAllSlugs();
        assertNotNull(slugs);
        assertEquals(3, slugs.size());
        assertTrue(slugs.contains("software-engineer-1"));
        assertTrue(slugs.contains("software-engineer-2"));
        assertTrue(slugs.contains("product-manager-1"));
    }
}