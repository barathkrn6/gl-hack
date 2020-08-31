package com.gl.hack.repo;

import com.gl.hack.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepo extends JpaRepository<Submission, Integer> {
}
