package com.resumeanalyzer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_descriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description; // Job role details

    private String requiredSkills; // Comma-separated list OR JSON
}
