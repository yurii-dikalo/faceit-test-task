package com.example.faceittesttask.repository;

import com.example.faceittesttask.model.Vacancy;
import com.example.faceittesttask.repository.responsemodel.Count;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    @Query("""
            SELECT new com.example.faceittesttask.repository.responsemodel.Count(v.location, count(v))
            FROM Vacancy v
            GROUP BY v.location
            ORDER BY count(v) DESC
            """)
    List<Count> getCountByLocation();

    @Query("SELECT v.slug FROM Vacancy v")
    List<String> findAllSlugs();
}
