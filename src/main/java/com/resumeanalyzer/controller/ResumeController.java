package com.resumeanalyzer.controller;

import com.resumeanalyzer.entity.Resume;
import com.resumeanalyzer.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import java.util.Map;
import java.util.HashMap; // Needed for creating HashMap

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

//    @PostMapping("/analyze")
//    @ResponseBody
//    public String analyzeResume(
//            @RequestParam("name") String name,
//            @RequestParam("file") MultipartFile file) {
//
//        // Just printing to console for testing
//        System.out.println("Name: " + name);
//        System.out.println("File: " + file.getOriginalFilename());
//
//        // Return simple message for now
//        return "Received: " + name + " -> " + file.getOriginalFilename();
//    }
//    @GetMapping("/analyze")
//    public Map<String, String> analyzeResume(@RequestParam String name) {
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Hello " + name + ", your resume is being analyzed!");
//        return response;
//    }
    // ✅ Upload resume file
    @PostMapping("/upload")
    public ResponseEntity<Resume> uploadResume(@RequestParam("file") MultipartFile file,
                                               @RequestParam("name") String candidateName,
                                               @RequestParam("email") String email) {
        Resume savedResume = resumeService.saveResume(file, candidateName, email);
        return ResponseEntity.ok(savedResume);
    }

    // ✅ Get all resumes
    @GetMapping("/getAll")
    public ResponseEntity<List<Resume>> getAllResumes() {
        return ResponseEntity.ok(resumeService.getAllResumes());
    }

    // ✅ Get resume by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        return ResponseEntity.ok(resumeService.getResumeById(id));
    }
}
