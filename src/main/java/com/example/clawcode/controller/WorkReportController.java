package com.example.clawcode.controller;

import com.example.clawcode.model.WorkReport;
import com.example.clawcode.repository.WorkReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/work-reports")
@CrossOrigin(origins = "*")
public class WorkReportController {

    @Autowired
    private WorkReportRepository workReportRepository;

    // 获取所有工作日报
    @GetMapping
    public List<WorkReport> getAllWorkReports() {
        return workReportRepository.findAll();
    }

    // 根据ID获取特定工作日报
    @GetMapping("/{id}")
    public ResponseEntity<WorkReport> getWorkReportById(@PathVariable Long id) {
        Optional<WorkReport> workReport = workReportRepository.findById(id);
        if (workReport.isPresent()) {
            return ResponseEntity.ok(workReport.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 创建新的工作日报
    @PostMapping
    public WorkReport createWorkReport(@RequestBody WorkReport workReport) {
        workReport.setDate(LocalDate.now()); // 设置当前日期
        return workReportRepository.save(workReport);
    }

    // 更新工作日报
    @PutMapping("/{id}")
    public ResponseEntity<WorkReport> updateWorkReport(@PathVariable Long id, @RequestBody WorkReport workReportDetails) {
        Optional<WorkReport> optionalWorkReport = workReportRepository.findById(id);
        if (optionalWorkReport.isPresent()) {
            WorkReport workReport = optionalWorkReport.get();
            workReport.setDate(workReportDetails.getDate());
            workReport.setWorkContent(workReportDetails.getWorkContent());
            workReport.setNextDayPlan(workReportDetails.getNextDayPlan());
            workReport.setCompletionStatus(workReportDetails.getCompletionStatus());
            workReport.setProblems(workReportDetails.getProblems());
            workReport.setSolutions(workReportDetails.getSolutions());
            WorkReport updatedWorkReport = workReportRepository.save(workReport);
            return ResponseEntity.ok(updatedWorkReport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 删除工作日报
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkReport(@PathVariable Long id) {
        workReportRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}