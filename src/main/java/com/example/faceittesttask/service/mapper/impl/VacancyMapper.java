package com.example.faceittesttask.service.mapper.impl;

import com.example.faceittesttask.dto.VacancyDto;
import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.service.mapper.DtoRequestMapper;
import com.example.faceittesttask.service.mapper.DtoResponseMapper;

public class VacancyMapper implements DtoRequestMapper<VacancyDto, Vacancy>,
        DtoResponseMapper<VacancyDto, Vacancy> {
    @Override
    public Vacancy toModel(VacancyDto dto) {
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
                model.getSlug(),
                model.getCompanyName(),
                model.getTitle(),
                model.isRemote(),
                model.getUrl(),
                model.getLocation(),
                model.getCreatedAt()
        );
    }
}
