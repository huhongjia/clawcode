package com.example.clawcode.repository;

import com.example.clawcode.model.WorkReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkReportRepository extends JpaRepository<WorkReport, Long> {
    List<WorkReport> findByDate(LocalDate date);
    List<WorkReport> findByDateBetween(LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT w FROM WorkReport w WHERE w.date = :date AND w.content LIKE %:keyword%")
    List<WorkReport> findByDateAndContentContaining(@Param("date") LocalDate date, @Param("keyword") String keyword);
}