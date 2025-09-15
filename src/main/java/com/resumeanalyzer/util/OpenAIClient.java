package com.resumeanalyzer.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OpenAIClient {

    private static final String OPENAI_API_KEY = "YOUR_OPENAI_API_KEY";
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    private final RestTemplate restTemplate;

    public OpenAIClient() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Sends resume text and job description to OpenAI to get similarity score and summary
     * @param resumeText Text extracted from resume
     * @param jobDescription Text from job description
     * @return response from OpenAI as String
     */
    // In OpenAIClient.java
    public String compareResumeWithJob(String resumeText, String jobDescription) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(OPENAI_API_KEY);

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", "Compare the resume to the job description and provide a similarity score (0-100) and a short summary. Resume: " + resumeText + " Job: " + jobDescription);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4");
        body.put("messages", new Map[]{message});
        body.put("temperature", 0);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = new RestTemplate().exchange(OPENAI_API_URL, HttpMethod.POST, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody().toString();
        } else {
            throw new RuntimeException("OpenAI API call failed: " + response.getStatusCode());
        }
    }

}
