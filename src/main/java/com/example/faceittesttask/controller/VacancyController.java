package com.example.faceittesttask.controller;

import com.example.faceittesttask.dto.VacancyDto;
import com.example.faceittesttask.repository.responsemodel.Count;
import com.example.faceittesttask.service.VacancyService;
import com.example.faceittesttask.service.mapper.impl.VacancyMapper;
import com.example.faceittesttask.util.SortUtil;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;
    private final SortUtil sortUtil;

    @Operation(description = "Get the list of all vacancies sorted and with pagination.")
    @GetMapping
    public List<VacancyDto> findAll(@RequestParam(defaultValue = "20")
                                    @Parameter(description =
                                            "The number of vacancies per page. Default value is 20.")
                                    Integer count,
                                    @RequestParam(defaultValue = "0")
                                    @Parameter(description =
                                            "The page number to retrieve. Default value is 0.")
                                    Integer page,
                                    @RequestParam(defaultValue = "createdAt")
                                    @Parameter(description =
                                            "The field to sort by. Default value is createdAt.")
                                    String sortBy) {
        Sort sort = sortUtil.getSort(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return vacancyService.findAll(pageRequest)
                .stream()
                .map(vacancyMapper::toDto)
                .toList();
    }

    @Operation(description = "Get the list of all vacancies counted and grouped by location.")
    @GetMapping("/group-by-location")
    public List<Count> getCountsByLocation() {
        return vacancyService.getCountByLocation();
    }
}
