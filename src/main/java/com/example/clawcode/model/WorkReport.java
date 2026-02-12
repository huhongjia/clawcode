package com.example.clawcode.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "work_reports")
public class WorkReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDate date;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String workContent;
    
    @Column(columnDefinition = "TEXT")
    private String nextDayPlan;
    
    @Column(columnDefinition = "TEXT")
    private String completionStatus;
    
    @Column(columnDefinition = "TEXT")
    private String problems;
    
    @Column(columnDefinition = "TEXT")
    private String solutions;
    
    // Constructors
    public WorkReport() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public String getWorkContent() { return workContent; }
    public void setWorkContent(String workContent) { this.workContent = workContent; }
    
    public String getNextDayPlan() { return nextDayPlan; }
    public void setNextDayPlan(String nextDayPlan) { this.nextDayPlan = nextDayPlan; }
    
    public String getCompletionStatus() { return completionStatus; }
    public void setCompletionStatus(String completionStatus) { this.completionStatus = completionStatus; }
    
    public String getProblems() { return problems; }
    public void setProblems(String problems) { this.problems = problems; }
    
    public String getSolutions() { return solutions; }
    public void setSolutions(String solutions) { this.solutions = solutions; }
}