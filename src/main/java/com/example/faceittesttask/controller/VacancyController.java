package com.example.faceittesttask.controller;

import com.example.faceittesttask.dto.VacancyDto;
import com.example.faceittesttask.service.VacancyService;
import com.example.faceittesttask.service.mapper.impl.VacancyMapper;
import com.example.faceittesttask.util.SortUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;
    private final SortUtil sortUtil;

    @ApiOperation(value = "Get the list of all vacancies sorted and with pagination.")
    @GetMapping
    public List<VacancyDto> findAll(@RequestParam(defaultValue = "20")
                                    @ApiParam(value =
                                            "The number of vacancies per page. Default value is 20.")
                                    Integer count,
                                    @RequestParam(defaultValue = "0")
                                    @ApiParam(value =
                                            "The page number to retrieve. Default value is 0.")
                                    Integer page,
                                    @RequestParam(defaultValue = "createdAt")
                                    @ApiParam(value =
                                            "The field to sort by. Default value is createdAt.")
                                    String sortBy) {
        Sort sort = sortUtil.getSort(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return vacancyService.findAll(pageRequest)
                .stream()
                .map(vacancyMapper::toDto)
                .toList();
    }
}
