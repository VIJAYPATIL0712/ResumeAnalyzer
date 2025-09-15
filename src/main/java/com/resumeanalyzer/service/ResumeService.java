package com.resumeanalyzer.service;

import com.resumeanalyzer.entity.Resume;
import com.resumeanalyzer.repository.ResumeRepository;
import com.resumeanalyzer.util.FileParser;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private FileParser fileParser;

    // Save uploaded resume file
    public Resume saveResume(MultipartFile file, String name, String email) {
        try {
            String content = fileParser.parseFile(file); // parse file content
            Resume resume = new Resume();
            resume.setName(name);
            resume.setEmail(email);
            resume.setContent(content);
            return resumeRepository.save(resume);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse resume file", e);
        } catch (TikaException e) {
            throw new RuntimeException(e);
        }
    }

    // Fetch all resumes
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    // Fetch resume by ID
    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found with id " + id));
    }
}
