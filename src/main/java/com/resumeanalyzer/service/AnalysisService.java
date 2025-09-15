package com.resumeanalyzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumeanalyzer.entity.AnalysisResult;
import com.resumeanalyzer.entity.JobDescription;
import com.resumeanalyzer.entity.Resume;
import com.resumeanalyzer.repository.AnalysisRepository;
import com.resumeanalyzer.repository.JobRepository;
import com.resumeanalyzer.repository.ResumeRepository;
import com.resumeanalyzer.util.OpenAIClient;

@Service
public class AnalysisService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private AnalysisRepository analysisRepository;

    @Autowired
    private OpenAIClient openAIClient;

    /**
     * Analyze a resume against a job description.
     *
     * @param resumeId The ID of the resume to analyze.
     * @param jobId    The ID of the job description to compare.
     * @return AnalysisResult saved in DB.
     */
    public AnalysisResult analyzeResume(Long resumeId, Long jobId) {
        // Fetch Resume entity
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        // Fetch Job entity
        JobDescription job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Call OpenAI client to analyze content
        String analysisText = openAIClient.compareResumeWithJob(resume.getContent(), job.getDescription());

        // Create and save AnalysisResult
        AnalysisResult result = new AnalysisResult();
        result.setResume(resume);
        result.setJob(job);
        result.setAnalysisText(analysisText);

        return analysisRepository.save(result);
    }
}
