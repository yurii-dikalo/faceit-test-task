package com.example.faceittesttask.service.mapper.impl;

import com.example.faceittesttask.dto.VacancyApiDto;
import com.example.faceittesttask.dto.VacancyDto;
import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.service.mapper.DtoRequestMapper;
import com.example.faceittesttask.service.mapper.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class VacancyMapper implements DtoRequestMapper<VacancyApiDto, Vacancy>,
        DtoResponseMapper<VacancyDto, Vacancy> {
    @Override
    public Vacancy toModel(VacancyApiDto dto) {
        Vacancy vacancy = new Vacancy();
        vacancy.setSlug(dto.slug());
        vacancy.setCompanyName(dto.companyName());
        vacancy.setTitle(dto.title());
        vacancy.setRemote(dto.remote());
        vacancy.setUrl(dto.url());
        vacancy.setLocation(dto.location());
        vacancy.setCreatedAt(dto.createdAt());
        return vacancy;
    }

    @Override
    public VacancyDto toDto(Vacancy model) {
        return new VacancyDto(
                model.getCompanyName(),
                model.getTitle(),
                model.isRemote(),
                model.getUrl(),
                model.getLocation(),
                model.getCreatedAt()
        );
    }
}
