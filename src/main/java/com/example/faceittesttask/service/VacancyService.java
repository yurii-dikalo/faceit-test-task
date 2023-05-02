package com.example.faceittesttask.service;

import com.example.faceittesttask.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VacancyService {
    private final VacancyRepository vacancyRepository;
}
