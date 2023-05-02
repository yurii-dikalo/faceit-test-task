package com.example.faceittesttask.dto;

public record VacancyDto(
        String slug,
        String companyName,
        String title,
        boolean remote,
        String url,
        String location,
        Long createdAt
) {
}
