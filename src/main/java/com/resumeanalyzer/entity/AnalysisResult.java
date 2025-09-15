package com.resumeanalyzer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis_results")
public class AnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to Resume entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    // Link to JobDescription entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private JobDescription job;

    // Analysis text returned from OpenAI
    @Column(columnDefinition = "TEXT")
    private String analysisText;

    // ---------------- Getters and Setters ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public JobDescription getJob() {
        return job;
    }

    public void setJob(JobDescription job) {
        this.job = job;
    }

    public String getAnalysisText() {
        return analysisText;
    }

    public void setAnalysisText(String analysisText) {
        this.analysisText = analysisText;
    }
}
