package com.interviewos.ostip.repository;

import com.interviewos.ostip.entity.InterviewTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InterviewTemplateRepo extends JpaRepository<InterviewTemplate, UUID> {
}
