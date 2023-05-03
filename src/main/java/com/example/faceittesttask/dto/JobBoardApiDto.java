package com.example.faceittesttask.dto;

import java.util.List;

public record JobBoardApiDto(
        List<VacancyApiDto> data,
        LinksDto links,
        MetaDto meta
) {
}
