package com.example.faceittesttask.service.mapper;

public interface DtoResponseMapper<D, M> {
    D toDto(M model);
}
