package com.resumeanalyzer.controller;

import com.resumeanalyzer.entity.Resume;
import com.resumeanalyzer.entity.JobDescription;
import com.resumeanalyzer.entity.AnalysisResult;
import com.resumeanalyzer.service.AnalysisService;
import com.resumeanalyzer.repository.ResumeRepository;
import com.resumeanalyzer.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis/abc")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/analyze")
    public AnalysisResult analyze(@RequestParam Long resumeId, @RequestParam Long jobId) {
        // Fetch the entities from the DB
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        JobDescription job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Call service with entities
        return analysisService.analyzeResume(resume.getId(), job.getId());
    }
}
