package com.resumeanalyzer.service;

import com.resumeanalyzer.entity.JobDescription;
import com.resumeanalyzer.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Save new job description
    public JobDescription saveJob(JobDescription job) {
        return jobRepository.save(job);
    }

    // Fetch all jobs
    public List<JobDescription> getAllJobs() {
        return jobRepository.findAll();
    }

    // Fetch job by ID
    public JobDescription getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
    }
}
