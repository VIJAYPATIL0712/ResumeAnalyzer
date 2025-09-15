package com.resumeanalyzer.dto;

public class AnalysisResponse {
    private Long resumeId;
    private Long jobId;
    private double matchScore;    // Similarity between resume & job
    private String summary;       // Summary or feedback from analysis

    public AnalysisResponse() {}

    public AnalysisResponse(Long resumeId, Long jobId, double matchScore, String summary) {
        this.resumeId = resumeId;
        this.jobId = jobId;
        this.matchScore = matchScore;
        this.summary = summary;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
