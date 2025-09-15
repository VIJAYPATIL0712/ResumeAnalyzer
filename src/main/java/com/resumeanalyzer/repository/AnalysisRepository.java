package com.resumeanalyzer.repository;

import com.resumeanalyzer.entity.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepository extends JpaRepository<AnalysisResult, Long> {
    // Add custom query methods if needed
}
