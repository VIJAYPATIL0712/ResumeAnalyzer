package com.resumeanalyzer.dto;

import org.springframework.web.multipart.MultipartFile;

public class ResumeRequest {
    private MultipartFile file;  // Resume file uploaded by user
    private String candidateName; // Optional candidate name

    public ResumeRequest() {}

    public ResumeRequest(MultipartFile file, String candidateName) {
        this.file = file;
        this.candidateName = candidateName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
}
