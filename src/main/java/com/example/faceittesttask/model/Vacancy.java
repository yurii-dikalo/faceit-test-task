package com.example.faceittesttask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vacancies")
@Getter
@Setter
@NoArgsConstructor
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug;
    @JsonProperty("company_name")
    private String companyName;
    private String title;
    private boolean remote;
    private String url;
    private String location;
    @JsonProperty("created_at")
    private Long createdAt;
}
