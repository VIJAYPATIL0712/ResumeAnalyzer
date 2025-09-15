package com.resumeanalyzer.controller;

import com.resumeanalyzer.entity.JobDescription;
import com.resumeanalyzer.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // ✅ Create new job description
    @PostMapping
    public ResponseEntity<JobDescription> createJob(@RequestBody JobDescription job) {
        return ResponseEntity.ok(jobService.saveJob(job));
    }

    // ✅ Get all job descriptions
    @GetMapping
    public ResponseEntity<List<JobDescription>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    // ✅ Get job by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobDescription> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }
}
